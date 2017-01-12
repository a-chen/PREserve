package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Make a new reservation with Selenium
 *
 */
public class NewReservation {

	private WebDriver driver;
	
	public NewReservation(WebDriver driver) {
		this.driver = driver;
		driver.get("http://localhost:9001/index");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setDate(String test_date){
		String X_PATH = "//*[@id=\"initial-reservation-selector\"]/div[2]/div[1]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_date);
		implicitWait();
	}
	
	public void setTime(String test_time){
		String X_PATH = "//*[@id=\"initial-reservation-selector\"]/div[2]/div[2]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_time);
		implicitWait();
	}
	
	public void setPatrons(String test_patrons){
		String X_PATH = "//*[@id=\"initial-reservation-selector\"]/div[2]/div[3]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_patrons);
		implicitWait();
	}
	
	public NewReservation clickTable(int table) {
		String X_PATH_Table1 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[1]/div[1]/div";
		String X_PATH_Table4 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[1]/div[2]/div";
		String X_PATH_Table7 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[1]/div[3]/div";
		String X_PATH_Table2 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[2]/div[1]/div";
		String X_PATH_Table5 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[2]/div[2]/div";
		String X_PATH_Table8 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[2]/div[3]/div";
		String X_PATH_Table3 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[3]/div[1]/div";
		String X_PATH_Table6 = "//*[@id=\"initial-reservation-selector\"]/div[3]/div[2]/div[3]/div[2]/div";
		
		String X_PATH=null;
		
		if(table==1) X_PATH=X_PATH_Table1;
		if(table==4) X_PATH=X_PATH_Table4;
		if(table==7) X_PATH=X_PATH_Table7;
		if(table==2) X_PATH=X_PATH_Table2;
		if(table==5) X_PATH=X_PATH_Table5;
		if(table==8) X_PATH=X_PATH_Table8;
		if(table==3) X_PATH=X_PATH_Table3;
		if(table==6) X_PATH=X_PATH_Table6;
		
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.click();
		implicitWait();
		System.out.println("Clicked table " + table);
		return new NewReservation(driver);
	}
	
	private void implicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
