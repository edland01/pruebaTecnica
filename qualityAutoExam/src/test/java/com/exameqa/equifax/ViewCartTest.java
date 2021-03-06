package com.exameqa.equifax;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCartTest {
	 private WebDriver driver;

	 @Before
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.saucedemo.com/");
	 }
	 
	@Test
	 public void testViewCart() throws InterruptedException {
		 WebElement userField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		 WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		 WebElement btnSubmit = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		 
		 WebDriverWait wait = new WebDriverWait(driver,2);
		 
		 userField.clear();
		 userField.sendKeys("standard_user");
		 Thread.sleep(1000);
		 passwordField.clear();
		 passwordField.sendKeys("secret_sauce");
		 Thread.sleep(1000);
		 btnSubmit.click();
		 Thread.sleep(2000);
		 
		 WebElement btnProduct = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button"));
		 WebElement btnKart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		 wait.until(ExpectedConditions.visibilityOf(btnProduct));
		 btnProduct.click();
		 Thread.sleep(1000);
		 btnKart.click(); //comentar para obtener escenario negativo
		
		 assertEquals("https://www.saucedemo.com/cart.html",driver.getCurrentUrl());
		 Thread.sleep(2200);
	 }
	 
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
	
}
