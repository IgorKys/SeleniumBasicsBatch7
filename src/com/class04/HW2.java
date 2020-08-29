package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {

	// HRMS Application Negative Login:
	// Open chrome browser
	// Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	// Enter valid username
	// Leave password field empty
	// Verify error message with text “Password cannot be empty” is displayed.

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("");

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();

		WebElement errorMessage = driver.findElement(By.id("spanMessage"));
		if (errorMessage.isDisplayed()) {
			String loginText = errorMessage.getText();
			System.out.println(loginText);
		}

	}

}
