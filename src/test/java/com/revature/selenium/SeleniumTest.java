package com.revature.selenium;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	private WebDriver driver;

	@Before
	public void makeDriver() {
		String PATH_TO_CHROME_DRIVER = "C:/Selenium/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
	}

	@Ignore
	@Test
	public void newReservation() {
		NewReservation reservation = new NewReservation(driver);
		// Check if page is opened
		org.junit.Assert.assertEquals("PREserve", reservation.getPageTitle());

		reservation.setDate("01122017");
		reservation.setTime("0930");
		reservation.setPatrons("2");
		reservation.clickTable(2);
		
		driver.quit();
	}
	
	@Test
	public void editReservation() {
		EditReservation reservation = new EditReservation(driver);
		// Check if page is opened
		org.junit.Assert.assertEquals("PREserve", reservation.getPageTitle());
		
		// choose reservation to test
		int reservationId = 1;
		
		reservation.openReservation(reservationId);
		reservation.setDate(reservationId, "01122017");
		reservation.setTime(reservationId, "0930");
		reservation.setPatrons(reservationId, "2");
		reservation.clickTable(reservationId, 3);
		
		driver.quit();
	}

}
