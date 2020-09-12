package com.practice;

import java.net.Socket;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigTask {

	static String url = "http://www.uitestpractice.com/Students/Index";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		WebElement nextBtn = driver.findElement(By.xpath("//a[@rel='next']"));
		// System.out.println(tableRows.size());

		boolean flag = true;
		while (flag) {
			List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
			for (WebElement row : tableRows) {
				String text = row.getText();
				// System.out.println(rowText);
				if (text.contains("Ban")) {
					flag=false;
					List<WebElement> dataActions = driver
							.findElements(By.xpath("//table[@class='table']/tbody/tr/td[4]/button"));
					for (WebElement data : dataActions) {
						String dataText = data.getText();
						if (dataText.contains("DELETE")) {
							Thread.sleep(3000);
							data.click();
							break;
						}
					}
				}

			}
			nextBtn.click();
		}

	}

}
