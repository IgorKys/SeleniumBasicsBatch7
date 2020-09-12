package com.review.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRecap {

	// selenum is an interface
	// GUI-Graphical User Interface
	// 1. GUI -- Selenium Interface
		
	// 2. API -- Application Programming Interface -- PostmanAPI -- Automate In Java
	// 3. Database  -- We keep all the data with tables -- SQL (Structered Query Language) MySQL and OracleSQL
	
	
	// WebElements
	// Locators
	// Radio Boxes
	// Checkboxes
	// Dropdowns and Multiple Selets
	// Select Class
	
	// buttons
	// links
	// input boxes
	// dropdown lists
	// check boxes
	// plain texes
	// radio buttons
	// other elements
	
	// we need to tell or give some information about to selenium about the web elements we want to test
	// we have to give address of these elements
	
	// to do so we use locators
	// id --> First Choice -- we can use directly
	// tagName --> 
	// class -- we can use directly
	// name  -- we can use directly
	// xpath
	// css selector
	// linkText
	// partialLinText
	
	
//	What is xpath -- language to locate nodes on XML or HTML
	// what kind of xpath do we have?
	// 1. Absolute  --> we can access any elements by starting from html tag
	
//	/html/body/script[20] --> 
	// 2. Relative
//	does not start from the begining
	
	//tagName[@attribute='value']
	//tagName[text()='value']
	
	//tagName[contains(@attribute, 'value')]
	//input[contains(@id,'-pickup')]
	
	//tagName[contains(text(), 'value')]
	
	
	//tagName[starts-with(@attribute, 'value')]
	//tagName[starts-with(text(), 'value')]
	
	
	// CSS Selector -- Cascading Style Sheet
	
	// most common CSS locators
	// 1. id  --> tagName#idValue
	// example  -->		div#Byry-pickup-smarty-wrapper
	
	// 2. class --> tagName.className
	// example  --> div._ia1._iam
	
	// 3. attribute  -->   tagName[attribute='value']
	// example		--> 	div[id='name-and-slogan']
	
											//					div[id='site-slogan']
			
	// ^  --> starts with  	--> tagName[attribute^='value']  --> div[id^='site-s']
	// $  --> ends with		--> tagName[attribute$='value']  --> div[id$='e-slogan']
	// *  --> contains 		--> tagName[attribute*='value']	 --> div[id*='e-slog']
	
//	break 15 mins ---
	
	
	
	
	
	
	

	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		WebElement departments=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		// Syntax of id, className, name, tagName, linkText and partialLinkText
		
//		driver.findElement(By.id("value"));
//		driver.findElement(By.className("value"));
//		driver.findElement(By.name("value"));
//		driver.findElement(By.tagName("value"));
//		driver.findElement(By.linkText("link text"));
//		driver.findElement(By.partialLinkText("partial link text"))
		
		departments.click();
		
		Thread.sleep(2000);
		driver.quit();

	}
	
	
}