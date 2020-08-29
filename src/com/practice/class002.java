package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class class002 {

	static String url = "https://syntaxtechs.com/selenium-practice/basic-checkbox-demo.php";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
		singleCheckbox.click();

		boolean selected = singleCheckbox.isSelected();
		System.out.println(selected);

		List<WebElement> multiCheckbox = driver.findElements(By.xpath("//input[@class = 'cb1-element']"));

		for (WebElement checkbox : multiCheckbox) {

			String text = checkbox.getAttribute("value");
			if (text.equals("Option-3")) {
				checkbox.click();
			}

		}

	}

}
