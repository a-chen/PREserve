package com.revature.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewReservation {

	private WebDriver driver;
	
	public NewReservation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDate(){
		driver.findElement(By.id("date")).click();
		implicitWait();
	}
	
	public void selectTime(){
		driver.findElement(By.id("timepicker1")).click();
		implicitWait();
	}
	
	public void selectPatrons(){
		driver.findElement(By.id("patrons")).click();
		implicitWait();
	}
	
	public NewReservation clickTable() {
		driver.findElement(By.name("table-id")).click();
		implicitWait();
		return new NewReservation(driver);
	}
	
	private void implicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
