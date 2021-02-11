package com.pratian.SauceDemo.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//*[@id='user-name']")
	WebElement username;

	@FindBy(xpath="//*[@id='password']")
	WebElement  pas;
	
	@FindBy(id="login-button")
	WebElement Loginbutton;





	public void SetUsername(String name) {
		this.username.click();
		this.username.sendKeys(name);
	}

	public void SetPassword(String pass) {
		this.pas.click();
		this.pas.sendKeys(pass);
	}
	
	public void clickLogin() {
		this.Loginbutton.click();
	}


	
	
	
	
	
	
	
}
