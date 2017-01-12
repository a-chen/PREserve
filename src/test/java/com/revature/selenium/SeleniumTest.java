package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
private WebDriver driver;
	
	@Before
	public void makeDriver(){
		String PATH_TO_CHROME_DRIVER = "C:/Selenium/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
	}
	
	@Test
	public void test(){

	}
	
}
