package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * this method navigates to hrms website
	 * 
	 * @return <-- driver
	 * @author Syntax
	 */
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

	}

	/**
	 * this method will quit the browser
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
