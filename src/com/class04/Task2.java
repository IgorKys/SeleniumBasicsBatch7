package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://amazon.com");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		for (WebElement link : allLinks) {
			String linkText = link.getText();
			// System.out.println(linkText);
			String fullLink = link.getAttribute("href");
			if (!linkText.isEmpty()) {
				System.out.println(linkText + "       " + fullLink);
			}

		}

	}
}
