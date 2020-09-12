package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTable {

	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		WebElement PIM = driver.findElement(By.linkText("PIM"));
		PIM.click();
		WebElement employeeList = driver.findElement(By.linkText("Employee List"));
		employeeList.click();
		WebElement idSort = driver.findElement(By.linkText("Id"));
		idSort.click();

		WebElement nextBtn = driver.findElement(By.linkText("Next"));

		String extpectedText = "05086A";
		boolean flag = true;

		while (flag) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
			for (WebElement row : rows) {
				String actualText = row.getText();
				if (actualText.contains(extpectedText)) {
					flag = false;
					WebElement employeId = driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_5086']"));
					employeId.click();
					break;
				}

			}
			nextBtn = driver.findElement(By.linkText("Next"));
			nextBtn.click();

		}

		driver.quit();

	}

}
