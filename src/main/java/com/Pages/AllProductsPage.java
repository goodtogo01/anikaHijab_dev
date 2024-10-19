package com.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Utilities.TestUtils;


public class AllProductsPage extends Helper {
 

	@FindBy(linkText = "All Products")
	WebElement products_manue;

	@FindBy(xpath = "//*[@id='main']/div/p")// "//p[contains(text(),'Showing 1–9 of 14 results')]")
	static
	WebElement showingItemsFirstPage;
	
	@FindBy(xpath = "//p[contains(text(),'Showing 1–9 of 14 results')]")
	static
	WebElement showingItemsNextPage;
	
	//*[@id='main']/div/p

	@FindBy(xpath = "//*[@id='main']/div/p")
	static
	WebElement showingList;

	@FindBy(xpath = "//*[@id='main']/div/form")
	WebElement validationSelectedList;
	String selectItemList = "//*[@id='main']/div/form/select";

	public static String totalDisplayed = "//*[@id='main']/div/ul/li";

	@FindBy(xpath = "//*[@class='page-numbers current']")
	static WebElement firstPage;
	
	@FindBy(xpath = "//*[@id='main']/div/nav[2]/ul/li[2]/a")
	static WebElement nextPage;

	//*[@id="main"]/div/ul/li[3]/div[1]/span
	
	public AllProductsPage() {
		PageFactory.initElements(driver, this);
	}
	

	public void navigateToAllProducts() {
		products_manue.click();
	}

	public String validatePageTitle(String expected_Title) {
		String originalTitle = driver.getTitle();
		System.out.println("The Page Title is : " + originalTitle);
		Assert.assertEquals(expected_Title, originalTitle, "Title is missing!!");
		return originalTitle;
	}

	public void selectCategory(String item) throws IOException {
		TestUtils.selectClass(selectItemList, item);

		// Take a Screenshot
		TestUtils.takeScreenShootSpecificElement(validationSelectedList);
		System.out.println("Screenshot has taken taken.");
	}

	public static void showingNumberOfProducts(String text) throws IOException {
		String result = showingItemsFirstPage.getText();
		Assert.assertEquals(result, text, "Item not showing as expected");
		System.out.println("Showing result as : " + result);

		// Take a Screenshot
		TestUtils.takeScreenShootSpecificElement(showingList);
		System.out.println("Screenshot has taken taken.");
	}

	public static void diplayedItems(int item) {
		int count = 0;
		List<WebElement> totalItemDisplayed = driver.findElements(By.xpath(totalDisplayed));
		for (int i = 0; i < totalItemDisplayed.size(); i++) {
			count++;
		}
		System.out.println("Total Item found as : " + count);
		Assert.assertEquals(count, item, "Item number mis-match.");

	}
	
	public static void firstPageValidation(int item, String text) throws IOException {
		firstPage.click();
		diplayedItems(item);
		// add showing products number 
		showingNumberOfProducts(text);
		
	}
	public static void secondPageValidation(int item, String text) throws IOException, InterruptedException {
		nextPage.click();
		diplayedItems(item);
		TestUtils.implicitelyWaitTime();
		showingNumberOfProducts(text);
		//add showing product number
	
	}
	
	
}
