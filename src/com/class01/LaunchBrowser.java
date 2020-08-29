package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https:www.amazon.com");
		Thread.sleep(3000);
		driver.navigate().to("https://google.com");
		Thread.sleep(5000);

//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());

		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Thread.sleep(5000);
		driver.close();

	}
}
