package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static  WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/iexplore.exe");
			driver=new InternetExplorerDriver();
	    }
		else {
		System.out.println("BROWSER ISSUE");
		     }
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
	}
		
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
}
