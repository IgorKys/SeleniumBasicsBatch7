package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		userName.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("Hum@nhrm123");
		WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		login.click();
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}
		

	}
}