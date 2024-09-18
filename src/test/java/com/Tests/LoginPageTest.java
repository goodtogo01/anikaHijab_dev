package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Pages.LoginPage;

public class LoginPageTest extends Helper{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void tearUp() {
		initializations();
		loginPage = new LoginPage();
		loginPage.goToAccountPage();
	}

	@Test(priority = 0, groups = "Sanity Test")
	public void pageTitleTest() {
	loginPage.validatePageTitle(prop.getProperty("accountPage"));
		
	}
	@Test(priority = 1, groups = "Regression Test")
	public void loginWithValidCredentials() throws IOException {
		loginPage.loginWithValidCredentials(prop.getProperty("userName"), 
				prop.getProperty("password"));
		loginPage.validateLoginMessages();
		loginPage.logOut();
		
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Driver is closed");
		driver.close();
	}
}
