package com.practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllActionsHW {

	public static String url = "https://artoftesting.com/samplesiteforselenium";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// 1. This is sample text!
		WebElement simpleText = driver.findElement(By.id("idOfDiv"));
		System.out.println("simpleText: " + simpleText.getText());

		// 2.Link : This is a link
		WebElement link = driver.findElement(By.linkText("This is a link"));
		link.click();

		String mainWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				System.out.println("Title of the link:" + driver.switchTo().window(window).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);

		// 3.TextBox
		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("Syntax");

		// 4.Click Button
		WebElement clickButton = driver.findElement(By.id("idOfButton"));
		Actions action = new Actions(driver);
		if (clickButton.isEnabled()) {
			action.click(clickButton).perform();
		}

		// 5.Double Click Button

		WebElement dobubleClick = driver.findElement(By.id("dblClkBtn"));
		action.doubleClick(dobubleClick).perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("DoubleClick alert text: " + alert.getText());
		alert.accept();

		// 6.Radio button

		List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement value : radioBtn) {
			String male = value.getAttribute("value");
			if (male.equals("male")) {
				Thread.sleep(2000);
				value.click();
			}
		}

		// 7.Checkbox

		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement value : checkbox) {
			String testing = value.getAttribute("value");
			if (testing.equals("Automation")) {
				Thread.sleep(2000);
				value.click();
			}
		}

		// 8.Drop down

		WebElement dropDown = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dropDown);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			String text = option.getText();
			if (text.equals("Performance Testing")) {
				select.selectByVisibleText(text);
			}

		}

		// 9.Click below button to generate Alert box

		WebElement generateAlertBox = driver.findElement(By.xpath("//button[text() ='Generate Alert Box']"));
		generateAlertBox.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println("Alert box text: " + alert.getText());
		alert.accept();

		// 10. Click below button to generate Confirm box
		WebElement generateConfirmBox = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
		generateConfirmBox.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();

		System.out.println("Confirm box text: " + alert.getText());
		alert.dismiss();

		// 11.Drag and drop example- drag the below image on the textbox

		WebElement sourceImage = driver.findElement(
				By.xpath("//img[@ondragstart='if (!window.__cfRLUnblockHandlers) return false; drag(event)']"));
		WebElement targetDiv = driver.findElement(
				By.xpath("//div[@ondragover='if (!window.__cfRLUnblockHandlers) return false; allowDrop(event)']"));
		Thread.sleep(3000);
		action.clickAndHold(sourceImage).moveToElement(targetDiv).release().build().perform();

	}
}
