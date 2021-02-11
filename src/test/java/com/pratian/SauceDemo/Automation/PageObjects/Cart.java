package com.pratian.SauceDemo.Automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cart extends BasePage {

	public Cart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void assertionChecking() {				
		WebElement element = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[2]/a[2]"));
		String Checkout = element.getText();
		
		Assert.assertEquals("CHECKOUT", Checkout);
		System.out.println("Cart Added successfully");
		 }









}
