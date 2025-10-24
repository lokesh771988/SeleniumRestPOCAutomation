package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
public class APITest extends BaseTest {
	
	@Test
	public void verifyGetUsersAPI() {
		test = extent.createTest("Get Users API Test");
		RestAssured.baseURI = "https://reqres.in";
		
		given()
		.header("Content-Type", "application/json")
		.queryParam("page", "2")
		.when()
		.get("/api/users")
		.then()
		.statusCode(200);
		test.pass("API Successful verifyied");
	}

}
