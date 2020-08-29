package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo1 {

	public static String url = "http://www.amazon.com/";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement accountAndLists = driver.findElement(By.id("nav-link-accountList"));

		Actions action = new Actions(driver);// create an object of action class and pass the argument
		action.moveToElement(accountAndLists).perform();

	}
}