package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	// Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html
	// Select any radiobutton and the age group ---> use List and loop
	// Click on get values
	// Verify the text in the page -- do not hardcode the values and compare

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html");

		List<WebElement> sexRadioBtn = driver.findElements(By.xpath("//input[@name='gender']"));

		for (WebElement btn : sexRadioBtn) {
			String sexAttribute = btn.getAttribute("value");
			if (sexAttribute.equals("Male")) {
				btn.click();
				break;
			}

		}

		List<WebElement> ageRadioBtn = driver.findElements(By.cssSelector("input[name='ageGroup']"));

		for (int i = 0; i < ageRadioBtn.size(); i++) {
			String ageAttribute = ageRadioBtn.get(i).getAttribute("value");
			if (ageAttribute.equals("5 - 15")) {
				ageRadioBtn.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//button [@onclick='getValues();']")).click();

		WebElement groupRadioBtn = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
		String groupRadioBtnText = groupRadioBtn.getText();
		System.out.println(groupRadioBtnText);
		System.out.println("______________");
		if (groupRadioBtnText.contains("Sex : Male") && groupRadioBtnText.contains("Age group: 5 - 15")) {
			System.out.println("You complete the task");
		}

	}

}
