package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageHW;
import com.utils.BaseClassHW;



public class LoginTestHW {

	LoginPageHW loginPage = new LoginPageHW();

	@BeforeMethod
	public void setUp() {
		BaseClassHW.setUp();
	}

	@AfterMethod
	public void tearDown() {
		BaseClassHW.tearDown();
	}

	@Test
	public void passwordEmpy() {
		loginPage = new LoginPageHW();
		loginPage.userName.sendKeys("Admin");
		loginPage.loginBtn.click();
		Assert.assertEquals(loginPage.spanMessage.getText(), loginPage.validUserNameAndPasswordEmpy);
	}

	@Test
	public void userNameAndPasswordEmpty() {
		loginPage = new LoginPageHW();
		loginPage.loginBtn.click();
		Assert.assertEquals(loginPage.spanMessage.getText(), loginPage.userNameAndPasswordEmpy);
	}

	@Test
	public void userNameAndWrongPassword() {
		loginPage = new LoginPageHW();
		loginPage.userName.sendKeys("Admin");
		loginPage.userPassword.sendKeys("Human");
		loginPage.loginBtn.click();
		Assert.assertEquals(loginPage.spanMessage.getText(), loginPage.validUserNameAndWrongPassword);
	}

}
