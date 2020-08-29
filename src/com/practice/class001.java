package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class class001 {

	static String url = "https://syntaxtechs.com/selenium-practice/basic-first-form-demo.php";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

		WebElement enterMessageSingle = driver.findElement(By.id("user-message"));
		enterMessageSingle.sendKeys("Syntax");

		WebElement showMessageSingle = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		String showMessageText = showMessageSingle.getText();
		if (showMessageText.equals("Show Message")) {
			showMessageSingle.click();
		}

		WebElement enterMessageValueA = driver.findElement(By.id("sum1"));
		enterMessageValueA.sendKeys("10");

		WebElement enterMessageValueB = driver.findElement(By.id("sum2"));
		enterMessageValueB.sendKeys("20");

		WebElement getTotal = driver.findElement(By.xpath("//button[@onclick='return total()']"));
		getTotal.click();

	}

}
