package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass{
	
	@Test(priority=1)
	public void loginApp()
	{
		logger=report.createTest("Login to facebook");
				
		ExcelDataProvider excel=new ExcelDataProvider();	
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("starting Details");
		
		loginPage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Helper.CaptureScreenshot(driver);
		
		logger.pass("Loggin successfully");
		
	}

/*	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout from facebook");
				
		logger.fail("Logout FAILED");
		
			
	}*/
}
