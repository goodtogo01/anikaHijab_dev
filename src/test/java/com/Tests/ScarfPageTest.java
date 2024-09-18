package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Pages.Hompage;
import com.Pages.ScarfPage;
import com.Utilities.TestUtils;

import io.qameta.allure.Step;

public class ScarfPageTest extends Helper{
	ScarfPage scarfPage;
	TestUtils testUtil;
	
	
	@BeforeMethod
	public void tearUp() {
		initializations();
		scarfPage = new ScarfPage();
		testUtil = new TestUtils();
		scarfPage.navigateToScarfPage();
	}

	@Step("Open WebSite")
	@Test(groups = "sanity")
	public void pageTitleTest() {
		
		scarfPage.validatePageTitle(prop.getProperty("scarfPageTitle"));
	}
	
	@SuppressWarnings({ "static-access"})
	@Test(groups = "Integration Testing")
	public void displayedTotalItems() {
		/*
		 In this Scarf page will displayed 10 items at a time
		 -- Based on current displayes, 10 is initial vaidation
		 * */	
		int input = 10;
		scarfPage.diplayedItems(input);
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Driver is closed");
		driver.close();
		log.info("Session is cmpleted");
	}
}
