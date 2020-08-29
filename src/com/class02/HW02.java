package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW02 {

	// 1. go to
	// https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
	// 2. Fill out the sign up form
	// 3. Click on register
	// 4. close the browser

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		Thread.sleep(2000);
		driver.findElement(By.name("customer.firstName")).sendKeys("John");
		driver.findElement(By.id("customer.lastName")).sendKeys("Snow");
		driver.findElement(By.id("customer.address.street")).sendKeys("25 Avenue");
		driver.findElement(By.name("customer.address.city")).sendKeys("Renton");
		driver.findElement(By.id("customer.address.state")).sendKeys("WA");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("98000");
		driver.findElement(By.name("customer.phoneNumber")).sendKeys("980 345 6787");
		driver.findElement(By.name("customer.ssn")).sendKeys("123-45-6789");
		driver.findElement(By.name("customer.username")).sendKeys("Snow565");
		driver.findElement(By.id("customer.password")).sendKeys("000JoHn");
		driver.findElement(By.id("repeatedPassword")).sendKeys("000JoHn");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
