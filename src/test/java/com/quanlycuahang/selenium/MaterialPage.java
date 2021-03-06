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

public class MaterialPage {
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
        txtTK.sendKeys("abc");
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
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * TH: Nhập đầy đủ các trường
	 * */
    @Test
    public void checkSaveMaterialGoodsNew() throws InterruptedException {
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	
    	txtMaHang.sendKeys("MH100");
    	txtTenHang.sendKeys("Mặt hàng 1");
    	txtDonVi.sendKeys("Bình");
    	txtDonGia.sendKeys("10000");
    	txtSoLuong.sendKeys("10");
    	btnSave.click();
    	
    	Thread.sleep(1500);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Lưu mặt hàng thành công");
    	
    	Thread.sleep(500);
    }
    
    /**
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * TH: Nhập thiếu mã hàng or mã hàng đã tồn tại
	 * */
    @Test
    public void checkSaveMaterialGoodsNewWithoutCodeOrCodeHasExist() throws InterruptedException {
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	
    	txtTenHang.sendKeys("Mặt hàng 1");
    	txtDonVi.sendKeys("Bình");
    	txtDonGia.sendKeys("10000");
    	txtSoLuong.sendKeys("10");
    	btnSave.click();
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập mã hàng");
    	
    	// nhập mã hàng trùng
    	Thread.sleep(1000);
    	txtMaHang.sendKeys("MH01");
    	btnSave.click();
    	Thread.sleep(1500);
    	WebElement info1 = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info1.getText(), "Lưu mã hàng đã tồn tại trong phần mềm");
    	Thread.sleep(500);
    }
    
    /**
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * TH: Nhập thiếu tên hàng
	 * */
    @Test
    public void checkSaveMaterialGoodsNewWithoutName() throws InterruptedException {
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
//    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	
    	txtMaHang.sendKeys("MH100");
//    	txtTenHang.sendKeys("Mặt hàng 1");
    	txtDonVi.sendKeys("Bình");
    	txtDonGia.sendKeys("10000");
    	txtSoLuong.sendKeys("10");
    	btnSave.click();
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập tên hàng");
    	
    	Thread.sleep(1500);
    }
    
    /**
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * TH: Nhập thiếu số lượng
	 * */
    @Test
    public void checkSaveMaterialGoodsNewWithoutQuantity() throws InterruptedException {
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
//    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	
    	txtMaHang.sendKeys("MH100");
    	txtTenHang.sendKeys("Mặt hàng 1");
    	txtDonVi.sendKeys("Bình");
    	txtDonGia.sendKeys("10000");
//    	txtSoLuong.sendKeys("10");
    	btnSave.click();
    	
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập số lượng");
    	
    	Thread.sleep(1500);
    }
    
    /**
	 * kiểm tra lưu mới một hàng hóa có mã chưa tồn tại
	 * TH: Nhập thiếu đơn giá
	 * */
    @Test
    public void checkSaveMaterialGoodsNewWithoutUnitPrice() throws InterruptedException {
    	WebElement btnThem = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[1]"));
    	btnThem.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
//    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	
    	txtMaHang.sendKeys("MH100");
    	txtTenHang.sendKeys("Mặt hàng 1");
    	txtDonVi.sendKeys("Bình");
//    	txtDonGia.sendKeys("10000");
    	txtSoLuong.sendKeys("10");
    	btnSave.click();
    	
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập đơn giá");
    	
    	Thread.sleep(1500);
    }
    
    /**
	 * kiểm tra sửa 1 hàng hóa
	 * TH: Các trường vẫn giữ nguyên nhưng Xóa tên hàng hóa
	 * */
    @Test
    public void checkUpdateMaterialGoodsButDeleteName() throws InterruptedException {
    	Thread.sleep(2000);
    	// bắt sự kiện dbclick vào 1 row của table để xem chi tiết row đó
    	Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	Thread.sleep(2000);
    	
//    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
//    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
//    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
//    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	
    	txtTenHang.clear();
    	txtTenHang.sendKeys(" ");
    	btnSave.click();
    	
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập tên hàng");
    }
    
    /**
	 * kiểm tra sửa 1 hàng hóa
	 * TH: Các trường vẫn giữ nguyên nhưng Xóa đơn giá
	 * */
    @Test
    public void checkUpdateMaterialGoodsButDeleteUnitPrice() throws InterruptedException {
    	Thread.sleep(2000);
    	// bắt sự kiện dbclick vào 1 row của table để xem chi tiết row đó
    	Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	Thread.sleep(2000);
    	
//    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
//    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
//    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
//    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	
    	txtDonGia.clear();
    	btnSave.click();
    	
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập đơn giá");
    }
    
    /**
	 * kiểm tra sửa 1 hàng hóa
	 * TH: Các trường vẫn giữ nguyên nhưng Xóa số lượng
	 * */
    @Test
    public void checkUpdateMaterialGoodsButDeleteQuantity() throws InterruptedException {
    	Thread.sleep(2000);
    	// bắt sự kiện dbclick vào 1 row của table để xem chi tiết row đó
    	Actions action = new Actions(driver);
    	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
    	action.doubleClick(rowSelect).perform();
    	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
    	Thread.sleep(2000);
    	
//    	WebElement txtMaHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodCode\"]"));
//    	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
//    	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
//    	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
    	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
    	
    	txtSoLuong.clear();
    	btnSave.click();
    	
    	Thread.sleep(1000);
    	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
    	assertEquals(info.getText(), "Bạn chưa nhập số lượng");
    }
    
  /**
	 * kiểm tra sửa 1 hàng hóa
	 * TH: Sửa giá trị của các trường với giá trị hợp lệ
	 * */
  @Test
  public void checkUpdateMaterialGoods() throws InterruptedException {
  	Thread.sleep(2000);
  	// bắt sự kiện dbclick vào 1 row của table để xem chi tiết row đó
  	Actions action = new Actions(driver);
  	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[2]/td[1]"));
  	action.doubleClick(rowSelect).perform();
  	WebElement btnSave = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood-update/div/div[1]/div/button[2]"));
  	Thread.sleep(2000);
  	
  	WebElement txtTenHang = this.driver.findElement(By.xpath("//*[@id=\"materialGoodName\"]"));
  	WebElement txtDonVi = this.driver.findElement(By.xpath("//*[@id=\"unit\"]"));
  	WebElement txtDonGia = this.driver.findElement(By.xpath("//*[@id=\"unitPrice\"]"));
  	WebElement txtSoLuong = this.driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
  	
  	txtTenHang.clear();
  	txtDonVi.clear();
  	txtDonGia.clear();
  	txtSoLuong.clear();
  	
	txtTenHang.sendKeys("Test 2");
	txtDonVi.sendKeys("Test 2");
	txtDonGia.sendKeys("15000");
	txtSoLuong.sendKeys("10");
  	btnSave.click();
  	
  	Thread.sleep(1000);
  	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
  	assertEquals(info.getText(), "Lưu mặt hàng thành công");
  }
    
    /**
   	 * kiểm tra xóa 1 hàng hóa
   	 * */
     @Test
     public void checkDeleteMaterialGoods() throws InterruptedException {
     	Thread.sleep(2000);
     	// bắt sự kiện click vào 1 row của table để xem chi tiết row đó
     	Actions action = new Actions(driver);
     	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[4]/td[1]"));
     	action.click(rowSelect).perform();
     	Thread.sleep(2000);
     	
     	WebElement btnDelete = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[2]"));
     	btnDelete.click();
     	Thread.sleep(1000);
     	
     	WebElement btnPopupDelete = this.driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/button[1]"));
     	btnPopupDelete.click();
     	Thread.sleep(2000);
     	
	  	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
	  	assertEquals(info.getText(), "Xóa mặt hàng thành công");
     }
     
     /**
     * kiểm tra xóa 1 hàng hóa
     * TH: Mặt hàng đã phát sinh ở chứng từ nhập hàng
     * */
      @Test
      public void checkDeleteMaterialGoodsWithMaterialExitAnyOrder() throws InterruptedException {
      	Thread.sleep(2000);
      	// bắt sự kiện click vào 1 row của table để xem chi tiết row đó
      	Actions action = new Actions(driver);
      	WebElement rowSelect = this.driver.findElement(By.xpath("//*[@id=\"scrollbar\"]/table/tbody/tr[4]/td[1]"));
      	action.click(rowSelect).perform();
      	Thread.sleep(2000);
      	
      	WebElement btnDelete = this.driver.findElement(By.xpath("/html/body/app-root/app-materialgood/div/div[1]/div/button[2]"));
      	btnDelete.click();
      	Thread.sleep(1000);
      	
      	WebElement btnPopupDelete = this.driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/button[1]"));
      	btnPopupDelete.click();
      	Thread.sleep(2000);
      	
 	  	WebElement info = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
 	  	assertEquals(info.getText(), "Mặt hàng này đã phát sinh chứng từ");
      }
}
