package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class class003 {

	static String url = "https://syntaxtechs.com/selenium-practice/basic-radiobutton-demo.php";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@name='optradio']"));

		for (WebElement btn : radioBtn) {
			String text = btn.getAttribute("value");
			if (text.equals("Female")) {
				btn.click();
			}
		}

		WebElement getCheck = driver.findElement(By.id("buttoncheck"));
		getCheck.click();

		List<WebElement> genderRadioBtn = driver.findElements(By.xpath("//input[@name='gender']"));

		for (WebElement genderBtn : genderRadioBtn) {
			genderRadioBtn.get(1).click();
		}

		List<WebElement> ageGroup = driver.findElements(By.xpath("//input[@name='ageGroup']"));

		for (WebElement age : ageGroup) {
			String value = age.getAttribute("value");
			if (value.equalsIgnoreCase("15 - 50")) {
				age.click();
			}
		}

		WebElement getValues = driver.findElement(By.xpath("//button[text() = 'Get values']"));
		getValues.click();

	}

}
