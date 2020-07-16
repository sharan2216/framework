package com.learnautomation.pages;



import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver ;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
 @FindBy(name="email")WebElement uname;
 @FindBy(name="pass")WebElement pass;
 @FindBy(id="loginbutton") WebElement login;
 //WebElement ele2=driver.findElement(By.xpath("//div[contains(@class, 'measure-tab') and contains(.//span, 'someText']"));
 
 public void loginToCRM(String usernameApplication,String passwordApplication)
  {
	 
	 //WebElement ele= driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a"));
	   //ele.click();
	  
	 
   uname.sendKeys(usernameApplication);
   pass.sendKeys(passwordApplication);
   login.click();
   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
     //driver.findElement(By.xpath("//input[@class='ui fluid large blue submit button'])")).click();
   
      
}
}
