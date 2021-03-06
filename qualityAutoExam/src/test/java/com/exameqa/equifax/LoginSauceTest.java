package com.exameqa.equifax;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSauceTest {
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
		 
		 userField.clear();
		 userField.sendKeys("standard_user");
		 Thread.sleep(1000);
		 passwordField.clear();
		 passwordField.sendKeys("secret_sauce");
		 Thread.sleep(1000);
		 btnSubmit.click();
		 Thread.sleep(1000);
		
		 assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
		 Thread.sleep(2000);
	 }
	 
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
}
