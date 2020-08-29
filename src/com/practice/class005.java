package com.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class class005 {

	static String url = "https://syntaxtechs.com/selenium-practice/javascript-alert-box-demo.php";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		WebElement simpleAlert = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		simpleAlert.click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();

		WebElement confirmAlert = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
		confirmAlert.click();
		Thread.sleep(2000);
		alert.dismiss();
		
		WebElement textConfirm = driver.findElement(By.id("confirm-demo"));
		String getTxt = textConfirm.getText();
		if(getTxt.contains("Cancel")) {
			System.out.println(getTxt);
		}
		
		WebElement promtAlert = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
		promtAlert.click();
		Thread.sleep(2000);
		alert.sendKeys("Hello");
		alert.accept();
		
		
		
		

	}

}
