package com.Tests;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Pages.Hompage;
import com.Utilities.TestUtils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

@Listeners
public class HomePageTest extends Helper {
	boolean status = false;
	Hompage homePage;
	TestUtils testUtil;
	

	@BeforeMethod
	public void tearUp() {
		initializations();
		homePage = new Hompage();
		testUtil = new TestUtils();
	}
	@Step("Open WebSite")
	@Test(groups = "Home Page Headers Functions")
	public void pageTitleTest() {
		
		homePage.validatePageTitle(prop.getProperty("homePageTitle"));
	}

	@Step("Home Page Header Functins")
	@Test(groups = "Smoke Test")
	public void headerManueListTest() throws IOException {
		// List of Header manue [Home, All Products, Under Cap, Scarf Pin, About,Contact ]
		homePage.headerManue("Home");
		testUtil.takeScreenShootSpecificElement(homePage.menu_List);
		testUtil.takeScreenShoot();
	}
	@Test(groups = "Home Page Headers Functions")
	public void homeManueDisplayTest() {
		homePage.homeManuDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void productsMenueDisplayTest() {
		homePage.productsMenueDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void scarfManuDisplayTest() {
		homePage.scarfManuDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void underCapManuDisplayTest() {
		homePage.underCapManuDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void scarfPinManuDisplayTest() {
		homePage.scarfPinManuDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void aboutMenueDisplayTest() {
		homePage.aboutMenueDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void contactMenueDisplayTest() {
		homePage.contactMenueDisplayed();
	}
	@Test(groups = "Home Page Headers Functions")
	public void accountListTest() {
		// Items available as [My account, Cart]
		System.out.println("Dropdown Menu Items found: ");
		homePage.validateAccountMenu();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Driver is closed");
		driver.close();
		log.info("Session is cmpleted");
	}
}
