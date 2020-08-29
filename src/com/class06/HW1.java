package com.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	// go to http://166.62.36.207/syntaxpractice/bootstrap-iframe.html
	// verify the logo is displayed on the first frame
	// verify the button is enabled on the second frame

	public static String url = "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.switchTo().frame("FrameOne");
		WebElement frameLogo = driver.findElement(By.id("hide"));

		if (frameLogo.isDisplayed()) {
			System.out.println("logo is displayed");
		} else {
			System.out.println("logo is not displayed");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame(0);

		WebElement frameButton = driver.findElement(By.xpath("//iframe[@name = 'FrameOne']"));

		System.out.println(frameButton.isEnabled());
		driver.switchTo().defaultContent();

	}
}
