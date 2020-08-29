package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class class004 {

	static String url = "https://syntaxtechs.com/selenium-practice/basic-select-dropdown-demo.php";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		WebElement singleDD = driver.findElement(By.id("select-demo"));

		Select select = new Select(singleDD);

		boolean isMultiple = select.isMultiple();
		System.out.println(isMultiple);

		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			String day = option.getText();
			if (day.equalsIgnoreCase("monday")) {
				select.selectByVisibleText(day);
			}

		}

		WebElement multiSelect = driver.findElement(By.id("multi-select"));

		Select selectCountries = new Select(multiSelect);

		List<WebElement> optionsCountries = selectCountries.getOptions();

		for (WebElement countries : optionsCountries) {
			String value = countries.getAttribute("value");
			if(value.equalsIgnoreCase("Florida")) {
				selectCountries.selectByValue(value);
			}
		}

	}

}
