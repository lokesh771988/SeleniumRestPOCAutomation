package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.xpath("//button[@type=\"submit\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String userName, String pass) {
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();
	}
	
	public boolean isDashboardVisible() {
		return driver.getTitle().contains("The Internet");
	}
}
