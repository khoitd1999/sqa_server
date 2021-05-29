package com.quanlycuahang.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
	WebDriver driver;
	
	@Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://qlch.herokuapp.com/");
        Thread.sleep(1000);
    }

    @After
    public void finish() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
    
    /**
	 * test account đúng
	 * */
    @Test
    public void testCheckUser() throws InterruptedException {
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("abc");
        txtMK.sendKeys("123");
        btnDangnhap.click();

        Thread.sleep(1000);

        String url = this.driver.getCurrentUrl();
        String urlExpect = "http://qlch.herokuapp.com/hang-hoa";

        assertEquals(url, urlExpect);

    }
    
    /**
	 * test tài khoản mật khẩu bỏ trống
	 * */
    @Test
    public void testCheckAccountEmpty() throws InterruptedException {
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("");
        txtMK.sendKeys("");
        btnDangnhap.click();

        WebElement error = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        Thread.sleep(1000);
        System.out.println("Thông báo lỗi là: " + error.getText());
        assertEquals(error.getText(), "Bạn chưa nhập đủ các trường bắt buộc");
        
    }
    
    /**
	 * test tài khoản đúng, mật khẩu sai
	 * */
    @Test
    public void testCheckAccountInCorrect() throws InterruptedException {
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("abc");
        txtMK.sendKeys("1234567");
        btnDangnhap.click();

        // Do cần phải vào db check tk nên cần phải deplay ở đây để đợi có kết quả thì thông báo mới hiện lên không thì sẽ lỗi chương trình do không có thông báo nào cả
        Thread.sleep(1000);
        WebElement error = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        Thread.sleep(1000);
        
        System.out.println("Thông báo lỗi là: " + error.getText());
        assertEquals(error.getText(), "Tài khoản hoặc mật khẩu nhập sai");
        
    }
    
    /**
	 * test tài khoản sai, mật khẩu đúng
	 * */
    @Test
    public void testCheckAccountInCorrect1() throws InterruptedException {
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("abcdefg");
        txtMK.sendKeys("123");
        btnDangnhap.click();
        
        // Do cần phải vào db check tk nên cần phải deplay ở đây để đợi có kết quả thì thông báo mới hiện lên không thì sẽ lỗi chương trình do không có thông báo nào cả
        Thread.sleep(1000);
        WebElement error = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        Thread.sleep(1000);
        
        System.out.println("Thông báo lỗi là: " + error.getText());
        assertEquals(error.getText(), "Tài khoản hoặc mật khẩu nhập sai");
        
    }
    
    
    /**
	 * test tài khoản sai, mật khẩu sai
	 * */
    @Test
    public void testCheckAccountInCorrect2() throws InterruptedException {
        WebElement txtTK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[1]"));
        WebElement txtMK = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/input[2]"));
        WebElement btnDangnhap = this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/div/button"));
        txtTK.sendKeys("abcdefg");
        txtMK.sendKeys("123456");
        btnDangnhap.click();

        // Do cần phải vào db check tk nên cần phải deplay ở đây để đợi có kết quả thì thông báo mới hiện lên không thì sẽ lỗi chương trình do không có thông báo nào cả
        Thread.sleep(1000);
        WebElement error = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
        Thread.sleep(1000);
        
        System.out.println("Thông báo lỗi là: " + error.getText());
        assertEquals(error.getText(), "Tài khoản hoặc mật khẩu nhập sai");
        
    }
}
