package com.pratian.SauceDemo.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	//Properties
	
	@FindBy(xpath = "//*[@id='inventory_container']/div/div[1]/div[3]/button")
	 WebElement addtocart;
	@FindBy(xpath = "//*[@id='shopping_cart_container']/a")
	 WebElement cart;
	
	
	

	public void clickAddToCart() {
		this.addtocart.click();
	}
	public void clickOnCartLogo() {
		this.cart.click();
		
	}

	








}
