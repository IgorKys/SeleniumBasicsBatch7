package com.class07;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW07 {

	// Go to https://demoqa.com/browser-windows
	// click on New Tab and print the text from new tab in the console
	// click on New Window and print the text from new window in the console
	// click on New Window Message and print the text from new window in the console
	// Verify the title is displayed
	// Print out the title of the main page

	static String url = "https://demoqa.com/browser-windows";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		String mainWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Tab
		WebElement newTabBtn = driver.findElement(By.id("tabButton"));
		newTabBtn.click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String newTabWindow : allWindows) {
			driver.switchTo().window(newTabWindow);
		}

		WebElement newTabText = driver.findElement(By.xpath("//h1[text() = 'This is a sample page']"));
		String textNewTab = newTabText.getText();
		System.out.println("text from new tab: " + textNewTab);
		driver.close();
		driver.switchTo().window(mainWindow);

		// Window
		WebElement newWindowBtn = driver.findElement(By.id("windowButton"));
		newWindowBtn.click();

		Set<String> mainAndNewWindow = driver.getWindowHandles();
		for (String newWindow : mainAndNewWindow) {
			driver.switchTo().window(newWindow);
			driver.manage().window().maximize();
		}

		String textNewWindow = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("text from new window: " + textNewWindow);
		driver.close();
		driver.switchTo().window(mainWindow);

		// WindowMessage
		WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
		newWindowMessage.click();

		Set<String> mainAndNewWindowMessage = driver.getWindowHandles();

		for (String windowMassage : mainAndNewWindowMessage) {
			driver.switchTo().window(windowMassage);
		}

		//String textwindowMessage = driver.findElement(By.xpath("/html/body")).getText();
		//System.out.println(textwindowMessage);
		driver.close();
		driver.switchTo().window(mainWindow);


		WebElement logo = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		boolean isDisplayed = logo.isDisplayed();
		System.out.println("logo is displayed? " + isDisplayed);

		System.out.println(driver.getTitle());
	}

}
