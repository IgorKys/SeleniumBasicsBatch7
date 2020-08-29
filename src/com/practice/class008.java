package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.ExceptionMethod;

public class class008 {

	// go to https://the-internet.herokuapp.com/dynamic_controls
	// click on checkbox and click on remove
	// verify the text
	// click on enable verify the textbox is enabled
	// enter text and click disable
	// verify the textbox is disabled

	static String url = "https://the-internet.herokuapp.com/dynamic_controls";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();

		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

		WebElement itsGone = driver.findElement(By.id("message"));
		System.out.println("text: " + itsGone.getText());

		WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

		WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));

		if (textbox.isEnabled()) {
			textbox.sendKeys("Syntax");
		} else {
			System.out.println("textbox is disable");
		}

		WebElement disableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		disableButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@style='width: 30%;']")));
		if (!disableButton.isEnabled()) {
			System.out.println("textbox is disable");
		}

	}

}
