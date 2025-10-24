package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/extentReport.html");
		extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void setupDriver() {		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE)
			test.fail(result.getThrowable());
		driver.quit();
	}
	
	@AfterSuite
	public void flaushReport() {
		extent.flush();
	}
}
