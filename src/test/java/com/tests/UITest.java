package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;

public class UITest extends BaseTest {

	@Test
	public void verifyLogin() {
		test = extent.createTest("Login Test");
		driver.get("https://the-internet.herokuapp.com/login");
		
		LoginPage login = new LoginPage(driver);
		login.login("tomsmith", "SuperSecretPassword!");
		
		Assert.assertTrue(login.isDashboardVisible(), "Login Failed");
		test.pass("login Successful and Dashboard visible");
	}
}
