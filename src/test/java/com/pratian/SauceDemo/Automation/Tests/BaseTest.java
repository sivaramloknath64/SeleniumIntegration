package com.pratian.SauceDemo.Automation.Tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pratian.SauceDemo.Automation.FileHandling.PropertyManager;


public class BaseTest {
	
	protected WebDriver driver;
	
	
	public static ExtentReports extent;
	@BeforeSuite
	public void Setup() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

		
	@BeforeClass
	public void setUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
   {
	driver.close();
	
	}
	
	@AfterSuite
	public void extentFlush() {
	extent.flush();

}
}