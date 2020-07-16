package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo {


public class Demo {
   @Test
   public void demo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        String url = "https://www.google.com";
        driver.get(url);
        Thread.sleep(2000);
        driver.close();
    }
}
}
