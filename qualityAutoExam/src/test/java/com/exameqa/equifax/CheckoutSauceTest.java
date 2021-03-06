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
import javax.swing.JOptionPane;

public class CheckoutSauceTest {
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
		 
		 /*LOGIN*/
		 userField.clear();
		 userField.sendKeys("standard_user"); //driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/text()[1]")).getText()
		 Thread.sleep(1000);
		 passwordField.clear();
		 passwordField.sendKeys("secret_sauce");
		 Thread.sleep(1000);
		 btnSubmit.click();
		 Thread.sleep(2000);
		 
		 /*SELECT PRODUCTO TO CART*/
		 WebElement btnProduct = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button"));
		 WebElement btnKart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		 wait.until(ExpectedConditions.visibilityOf(btnProduct));
		 btnProduct.click();
		 Thread.sleep(1000);
		 btnKart.click();
		 
		 /*TO CHECKOUT INFORMATION*/
		 WebElement btnChkOut = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		 wait.until(ExpectedConditions.visibilityOf(btnChkOut));
		 btnChkOut.click();
		 
		 WebElement inputName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
		 WebElement inputLastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
		 WebElement inputZipCode = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
		 WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		 
		 wait.until(ExpectedConditions.visibilityOf(btnContinue));
		 Thread.sleep(1000);
		 
		 inputName.clear();
		 inputName.sendKeys("Eduardo Alexis");
		 Thread.sleep(1000);
		 
		 inputLastName.clear();
		 inputLastName.sendKeys("Landaverde Gonzalez");
		 Thread.sleep(1000);
		 
		 inputZipCode.clear();
		 inputZipCode.sendKeys("11201");
		 Thread.sleep(1000);
		 
		 
		 btnContinue.click();
		 
		 
		 assertEquals("https://www.saucedemo.com/checkout-step-two.html",driver.getCurrentUrl());
		 Thread.sleep(2000);
	 }
	 
	 @After
	 public void tearDown() {
		 JOptionPane.showMessageDialog(null,"Test is complete. Click to close");
		 driver.quit();
	 }
}
