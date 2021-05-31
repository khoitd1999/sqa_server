package com.quanlycuahang.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    public void checkSaveOrderNew() throws InterruptedException {
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
    	txtNgayNhanHang.sendKeys("20/03/2025");
    	
    	// Nhập phần chi tiết đơn hàng
    	
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
    
    /**
	 * kiểm tra lưu mới một đơn nhập hàng 
	 * TH: Nhập đầy đủ các trường
	 * không nhập số đơn hàng hoặc nhập trùng số đơn hàng đã tồn tại
	 * */
    @Test
    public void checkSaveOrderNewWithoutNoOrNoHasExist() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	// Nhập phần thông tin chung
    	
    	WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
    	// chọn thằng ncc đầu tiên
    	Select selectNCC = new Select(this.driver.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
    	selectNCC.selectByIndex(0);
    	// chọn thằng nhân viên thực hiện đầu tiên
    	Select selectNV = new Select(this.driver.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
    	selectNV.selectByIndex(0);
    	WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2025");
    	
    	// Nhập phần chi tiết đơn hàng
    	
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
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập số đơn hàng");
    	
    	// nhập số đơn hàng trùng
    	Thread.sleep(1000);
    	txtSoDonHang.sendKeys("DH01");
    	btnSave.click();
    	Thread.sleep(1500);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info1.getText(), "Mã đơn hàng đã tồn tại trong phần mềm");
    	Thread.sleep(500);
    }
    
	/**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại 
	 * TH: Nhập đầy đủ các trường nhưng không nhập ngày nhận hàng hoặc nhập ngày sai định dạng dd/MM/yyyy
	 */
	@Test
	public void checkSaveOrderNewWithoutDateOrDateWrongFormat() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btnThem = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
		btnThem.click();

		Thread.sleep(2000);

		// Nhập phần thông tin chung

		WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
		txtSoDonHang.sendKeys("DH100");
		// chọn thằng ncc đầu tiên
		Select selectNCC = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
		selectNCC.selectByIndex(0);
		// chọn thằng nhân viên thực hiện đầu tiên
		Select selectNV = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
		selectNV.selectByIndex(0);
		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));

		// Nhập phần chi tiết đơn hàng

		WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
		themDongMoi.click();
		Thread.sleep(500);
		// chọn thằng hàng hóa đầu tiên
		Select selectHangHoa = new Select(
				this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
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
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Bạn chưa nhập ngày nhận hàng");
		
    	// nhập ngày nhận hàng sai format
    	Thread.sleep(1000);
    	txtNgayNhanHang.sendKeys("abc");
    	btnSave.click();
    	Thread.sleep(1500);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info1.getText(), "Bạn chưa nhập đúng định dạng ngày");
    	
		Thread.sleep(500);
	}
	
	/**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại 
	 * TH: Không nhập chi tiết đơn hàng
	 */
	@Test
	public void checkSaveOrderNewWithoutDetailOrder() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btnThem = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
		btnThem.click();

		Thread.sleep(2000);

		// Nhập phần thông tin chung

		WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
		txtSoDonHang.sendKeys("DH100");
		// chọn thằng ncc đầu tiên
		Select selectNCC = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
		selectNCC.selectByIndex(0);
		// chọn thằng nhân viên thực hiện đầu tiên
		Select selectNV = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
		selectNV.selectByIndex(0);
		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2025");
		// Nhập phần chi tiết đơn hàng

//		WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
//		themDongMoi.click();
//		Thread.sleep(500);
//		// chọn thằng hàng hóa đầu tiên
//		Select selectHangHoa = new Select(
//				this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
//		selectHangHoa.selectByIndex(0);
//		WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
//		txtSoLuong.sendKeys("10");
//		WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
//		txtDonGia.sendKeys("100000");
//		WebElement txtTiLeChietKhau = this.driver.findElement(By.xpath("//*[@id=\"discountRate\"]"));
//		txtTiLeChietKhau.sendKeys("20");
//		// chọn thằng thuế suất thứ 2
//		Select selectVAT = new Select(this.driver.findElement(By.xpath("//*[@id=\"vatRate\"]")));
//		selectVAT.selectByIndex(1);
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Đơn hàng đang không có hàng hóa nào");
    	
		Thread.sleep(500);
	}
	
	/**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại 
	 * TH: Trong chi tiết đơn hàng không chọn mã hàng
	 */
	@Test
	public void checkSaveOrderNewWithoutMaterial() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btnThem = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
		btnThem.click();

		Thread.sleep(2000);

		// Nhập phần thông tin chung

		WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
		txtSoDonHang.sendKeys("DH100");
		// chọn thằng ncc đầu tiên
		Select selectNCC = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
		selectNCC.selectByIndex(0);
		// chọn thằng nhân viên thực hiện đầu tiên
		Select selectNV = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
		selectNV.selectByIndex(0);
		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2025");
		// Nhập phần chi tiết đơn hàng

		WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
		themDongMoi.click();
		Thread.sleep(500);
		// chọn thằng hàng hóa đầu tiên
//		Select selectHangHoa = new Select(
//				this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
//		selectHangHoa.selectByIndex(0);
		WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		txtSoLuong.sendKeys("10");
		WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
		txtDonGia.sendKeys("100000");
		WebElement txtTiLeChietKhau = this.driver.findElement(By.xpath("//*[@id=\"discountRate\"]"));
		txtTiLeChietKhau.sendKeys("20");
		// chọn thằng thuế suất thứ 2
		Select selectVAT = new Select(this.driver.findElement(By.xpath("//*[@id=\"vatRate\"]")));
		selectVAT.selectByIndex(1);
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Hàng 1 chưa nhập mã hàng hóa");
    	
		Thread.sleep(500);
	}
	
	/**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại 
	 * TH: Trong chi tiết đơn hàng không nhập số lượng hoặc nhập số âm
	 */
	@Test
	public void checkSaveOrderNewWithoutQuantityOrQuantityNegative() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btnThem = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
		btnThem.click();

		Thread.sleep(2000);

		// Nhập phần thông tin chung

		WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
		txtSoDonHang.sendKeys("DH100");
		// chọn thằng ncc đầu tiên
		Select selectNCC = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
		selectNCC.selectByIndex(0);
		// chọn thằng nhân viên thực hiện đầu tiên
		Select selectNV = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
		selectNV.selectByIndex(0);
		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2025");
		// Nhập phần chi tiết đơn hàng

		WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
		themDongMoi.click();
		Thread.sleep(500);
		// chọn thằng hàng hóa đầu tiên
		Select selectHangHoa = new Select(
				this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
		selectHangHoa.selectByIndex(0);
		WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
		txtDonGia.sendKeys("100000");
		WebElement txtTiLeChietKhau = this.driver.findElement(By.xpath("//*[@id=\"discountRate\"]"));
		txtTiLeChietKhau.sendKeys("20");
		// chọn thằng thuế suất thứ 2
		Select selectVAT = new Select(this.driver.findElement(By.xpath("//*[@id=\"vatRate\"]")));
		selectVAT.selectByIndex(1);
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Hàng 1 có số lượng nhỏ hơn hoặc bằng 0");
    	
    	// nhập số lượng âm
    	Thread.sleep(1000);
    	txtSoLuong.sendKeys("-10");
    	Thread.sleep(7000);
    	btnSave.click();
    	Thread.sleep(2000);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]"));
    	assertEquals(info1.getText(), "Hàng 1 có số lượng nhỏ hơn hoặc bằng 0");
		Thread.sleep(500);
	}
    
    /**
	 * kiểm tra lưu mới một đơn nhập hàng có mã chưa tồn tại 
	 * TH: Trong chi tiết đơn hàng không nhập đơn giá hoặc nhập số âm
	 */
	@Test
	public void checkSaveOrderNewWithoutUnitPriceOrUnitPriceNegative() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btnThem = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[1]"));
		btnThem.click();

		Thread.sleep(2000);

		// Nhập phần thông tin chung

		WebElement txtSoDonHang = this.driver.findElement(By.xpath("//*[@id=\"no\"]"));
		txtSoDonHang.sendKeys("DH100");
		// chọn thằng ncc đầu tiên
		Select selectNCC = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[2]/div/select")));
		selectNCC.selectByIndex(0);
		// chọn thằng nhân viên thực hiện đầu tiên
		Select selectNV = new Select(this.driver.findElement(
				By.xpath("/html/body/app-root/app-pporder-update/div/div[2]/div/div/form/div/div/div[5]/div/select")));
		selectNV.selectByIndex(0);
		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
    	txtNgayNhanHang.sendKeys("20/03/2025");
		// Nhập phần chi tiết đơn hàng

		WebElement themDongMoi = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]"));
		themDongMoi.click();
		Thread.sleep(500);
		// chọn thằng hàng hóa đầu tiên
		Select selectHangHoa = new Select(
				this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[1]/td[1]/select")));
		selectHangHoa.selectByIndex(0);
		WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		txtSoLuong.sendKeys("10");
		WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
		WebElement txtTiLeChietKhau = this.driver.findElement(By.xpath("//*[@id=\"discountRate\"]"));
		txtTiLeChietKhau.sendKeys("20");
		// chọn thằng thuế suất thứ 2
		Select selectVAT = new Select(this.driver.findElement(By.xpath("//*[@id=\"vatRate\"]")));
		selectVAT.selectByIndex(1);
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Hàng 1 có đơn giá nhỏ hơn hoặc bằng 0");
    	
    	// nhập đơn giá âm
    	Thread.sleep(1000);
    	txtDonGia.sendKeys("-10");
    	Thread.sleep(7000);
    	btnSave.click();
    	Thread.sleep(2000);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]"));
    	assertEquals(info1.getText(), "Hàng 1 có đơn giá nhỏ hơn hoặc bằng 0");
		Thread.sleep(500);
	}
    
	/**
	 * kiểm tra update  một đơn nhập hàng 
	 * TH: nhập ngày nhận đơn hàng sai định dạng
	 */
	@Test
	public void checkUpdateOrderWithDateWrongFormat() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();

		Thread.sleep(2000);

		WebElement txtNgayNhanHang = this.driver.findElement(By.xpath("//*[@id=\"date\"]"));
		txtNgayNhanHang.clear();
		txtNgayNhanHang.sendKeys("abc");
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Bạn chưa nhập đúng định dạng ngày");
	}
	
	/**
	 * kiểm tra update  một đơn nhập hàng 
	 * TH: nhập xóa số lượng hoặc nhập số lượng âm
	 */
	@Test
	public void checkUpdateOrderWithoutQuantityOrQuantityNegative() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();

		Thread.sleep(2000);

		WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		txtSoLuong.clear();
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Hàng 1 có số lượng nhỏ hơn hoặc bằng 0");
    	
    	// nhập số lượng âm
    	Thread.sleep(1000);
    	txtSoLuong.sendKeys("-10");
    	Thread.sleep(7000);
    	btnSave.click();
    	Thread.sleep(2000);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]"));
    	assertEquals(info1.getText(), "Hàng 1 có số lượng nhỏ hơn hoặc bằng 0");
		Thread.sleep(500);
	}
	
	/**
	 * kiểm tra update  một đơn nhập hàng 
	 * TH: nhập xóa đơn giá hoặc nhập đơn giá âm
	 */
	@Test
	public void checkUpdateOrderWithoutUnitPriceOrUnitPriceNegative() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();

		Thread.sleep(2000);

		WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
		txtDonGia.clear();
		WebElement btnSave = this.driver
				.findElement(By.xpath("/html/body/app-root/app-pporder-update/div/div[1]/div/button[2]"));
		btnSave.click();
		Thread.sleep(1000);
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
		assertEquals(info.getText(), "Hàng 1 có đơn giá nhỏ hơn hoặc bằng 0");
    	
    	// nhập số lượng âm
    	Thread.sleep(1000);
    	txtDonGia.sendKeys("-10");
    	Thread.sleep(7000);
    	btnSave.click();
    	Thread.sleep(2000);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]"));
    	assertEquals(info1.getText(), "Hàng 1 có đơn giá nhỏ hơn hoặc bằng 0");
		Thread.sleep(500);
	}
	
	/**
	 * kiểm tra update  một đơn nhập hàng 
	 * TH: nhập xóa Chứng từ nhập hàng
	 */
	@Test
	public void checkDeleteOrder() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[3]/td[1]"));
    	action.click(rowSelect).perform();

		Thread.sleep(2000);

		WebElement btnDelete = this.driver.findElement(By.xpath("/html/body/app-root/app-pporder/div/div[1]/div/button[2]"));
		btnDelete.click();
		
		Thread.sleep(2000);
		
		WebElement btnPopupDelete = this.driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/button[1]"));
		btnPopupDelete.click();
		
		Thread.sleep(5000);
		
		WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Xóa đơn hàng thành công");
		Thread.sleep(500);
	}
}
