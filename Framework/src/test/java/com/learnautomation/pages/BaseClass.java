package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and  test is getting ready",true);
				excel =new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Facebook_Reports"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
	}
	@BeforeClass
	public void setup()
	{
		//driver=BrowserFactory.startApplication(driver,"chrome","https://freecrm.co.in/");
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser and application up and running",true);
	}
	
    @AfterClass
	public void teardown() throws InterruptedException
	{
    	Thread.sleep(10000);
    	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		BrowserFactory.quitBrowser(driver);	
		
	}
    
@AfterMethod
public void tearDownMethod(ITestResult result) throws IOException
{
	Reporter.log("Test is about to end",true);
	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		Helper.CaptureScreenshot(driver);
		logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
	
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		
	}
		
	report.flush();
	Reporter.log("Test Completed>>>>>> Reports generated",true);
}
}
