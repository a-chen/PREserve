package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
 *	Edit a reservation with Selenium 
 */
public class EditReservation {

	private WebDriver driver;
	
	public EditReservation(WebDriver driver) {
		this.driver = driver;
		driver.get("http://localhost:9001/index");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void openReservation(int reservationId) {
		String X_PATH = "//*[@id=\"reservation-"
				+reservationId + "\"]/div/div/div[1]/h4";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.click();
		implicitWait();
	}
		
	public void setDate(int reservationId, String test_date){
		String X_PATH = "//*[@id=\"collapse-reservation-"
				+ reservationId + "\"]/div/div[1]/div[1]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_date);
		implicitWait();
	}
	
	public void setTime(int reservationId, String test_time){
		String X_PATH = "//*[@id=\"collapse-reservation-"
				+ reservationId + "\"]/div/div[1]/div[2]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_time);
		implicitWait();
	}
	
	public void setPatrons(int reservationId, String test_patrons){
		String X_PATH = "//*[@id=\"collapse-reservation-"
				+ reservationId + "\"]/div/div[1]/div[3]/div/input";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.sendKeys(test_patrons);
		implicitWait();
	}
	
	public NewReservation clickTable(int reservationId, int tableId) {
		String X_PATH = "//div[@id='reservation-"
				+ reservationId + "']//div[contains(concat(' ', @class, ' '), ' table" 
				+ tableId + " ')]/div";
		WebElement link = driver.findElement(By.xpath(X_PATH));
		link.click();
		implicitWait();
		System.out.println("Clicked table " + tableId);
		return new NewReservation(driver);
	}
	
	private void implicitWait() {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	
}
