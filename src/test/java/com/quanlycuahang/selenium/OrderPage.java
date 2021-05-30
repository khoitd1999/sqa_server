package com.quanlycuahang.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
	WebDriver driver;
	@Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://qlch.herokuapp.com/");
        Thread.sleep(1000);
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("admin");
        txtMK.sendKeys("123");
        btnDangnhap.click();

        Thread.sleep(1000);
    }

    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
    
    /**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại
	 * TH: Nhập đầy đủ các trường
	 * */
    @Test
    public void checkSaveMaterialGoodsNew() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	// Nhập phần thông tin chung
    	
    	WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
    	txtSoDonHang.sendKeys("DH002");
    	// chọn thằng ncc đầu tiên
    	Select selectNCC = new Select(this.driver.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
    	selectNCC.selectByIndex(0);
    	// chọn thằng nhân viên thực hiện đầu tiên
    	Select selectNV = new Select(this.driver.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
    	selectNV.selectByIndex(0);
    	WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2021");
    	
    	// Nhập phần chi tiết
    	
    	WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
    	themDongMoi.click();
    	Thread.sleep(500);
    	// chọn thằng hàng hóa đầu tiên
    	Select selectHangHoa = new Select(this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
    	selectHangHoa.selectByIndex(0);
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	txtSoLuong.sendKeys("10");
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	txtDonGia.sendKeys("100000");
    	WebElement txtTiLeChietKhau = this.driver.findElement(By.xpath("//*[@id=\"discountRate\"]"));
    	txtTiLeChietKhau.sendKeys("20");
    	// chọn thằng thuế suất thứ 2
    	Select selectVAT = new Select(this.driver.findElement(By.xpath("//*[@id=\"vatRate\"]")));
    	selectVAT.selectByIndex(1);
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
    	btnSave.click();
    	Thread.sleep(2000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Lưu đơn hàng thành công");
    	
    	Thread.sleep(500);
    }
}
