package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClassHW;

public class LoginPageHW extends BaseClassHW {

	@FindBy(id = "txtUsername")
	public WebElement userName;

	@FindBy(xpath = "//input[@name='txtPassword']")
	public WebElement userPassword;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement spanMessage;

	public String userNameAndPasswordEmpy = "Username cannot be empty";
	public String validUserNameAndPasswordEmpy = "Password cannot be empty";
	public String validUserNameAndWrongPassword = "Invalid credentials";

	public LoginPageHW() {
		PageFactory.initElements(driver, this);

	}

}
