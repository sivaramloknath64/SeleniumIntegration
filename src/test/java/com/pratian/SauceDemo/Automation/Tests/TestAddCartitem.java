package com.pratian.SauceDemo.Automation.Tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pratian.SauceDemo.Automation.FileHandling.PropertyManager;
import com.pratian.SauceDemo.Automation.PageObjects.Cart;
import com.pratian.SauceDemo.Automation.PageObjects.HomePage;
import com.pratian.SauceDemo.Automation.PageObjects.LoginPage;

public class TestAddCartitem extends BaseTest {


	ExtentTest Test;


	@BeforeTest
	public void sigin()
	{

	}
	@Test(dataProvider = "signIn")
	public void AddtoCart(String Name, String pass) throws Exception
	{
		Test = extent.createTest("AddItem", "Add to cart items");
		driver.get(PropertyManager.getProperty("url.app"));

		Test.info("Opening the url");
		LoginPage login=new LoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Test.info("Entering userName");
		login.SetUsername(Name);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Test.info("Entering password");
		login.SetPassword(pass);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Test.info("Click Login");
		login.clickLogin();


		HomePage home=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Test.log(Status.INFO, "Adding item to cart");
		home.clickAddToCart();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Test.log(Status.INFO, "Click on Cart");
		home.clickOnCartLogo();

		Cart newcart=new Cart(driver);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Test.log(Status.INFO, "Assertion for checkout ");
		newcart.assertionChecking();



		this.takeSnapShot(driver, "./screenshots/SwaglabsCart.png");



	}




	public static void takeSnapShot(WebDriver driver,String filePath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot screenshot =((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file

		File SourceFile=screenshot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(filePath);

		//Copy file at destination

		FileUtils.copyFile(SourceFile, DestFile);

	}



	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"standard_user","secret_sauce"} 	

		};
	}





}



