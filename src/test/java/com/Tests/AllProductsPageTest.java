package com.Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Pages.AllProductsPage;

public class AllProductsPageTest extends Helper {

	AllProductsPage allProductsPage;

	@BeforeMethod
	public void tearUp() {
		initializations();
		allProductsPage = new AllProductsPage();
		allProductsPage.navigateToAllProducts();
	}

	@Test(groups = "Smoke Testing")
	public void pageTitleTest() {
		allProductsPage.validatePageTitle(prop.getProperty("allProductsTitle"));
	}

	@Test(groups = "Integration Testing")
	public void selectByCategoryTest() throws IOException {
		/*
		 * List of Category is present as: [ Default sorting, Sort by popularity, Sort
		 * by average rating, Sort by latest, Sort by price: low to high, Sort by price:
		 * high to low ]
		 */
		allProductsPage.selectCategory("Sort by price: low to high");

	}

	@Test(groups = "Integration Testing")
	public void showingProductsCount() throws IOException {
		// Current range is = [Showing 1–9 of 14 results, Showing 10–14 of 14 results ]
		allProductsPage.showingNumberOfProducts("Showing 1–9 of 14 results");

	}

	@SuppressWarnings({ "static-access"})
	@Test(groups = "Integration Testing")
	public void displayedItemTest() {
	/*
	 Total items (as of now) are 14, 
		-- First page will contained 9 items
		-- Second page will contained 5 items
	*/	
		int input = 9; // Based on scenario, validation Input either 9 or 5 
		allProductsPage.diplayedItems(input);
		System.out.println("Validation passed with : "+input);
	}

	@Test(groups = "Integration Testing")
	public static void firstPageValidationTest() throws IOException {
		/*
		 => Validation 1: Total items (as of now) are 14, 
			-- First page will contained 9 items
			-- Second page will contained 5 items
		=> Validation 2: Current range is = 
		   	-- Showing 1–9 of 14 results, 
		    -- Showing 10–14 of 14 results 
		*/	
		int input = 9; // Based on scenario, validation Input either 9 or 5 
		String text = "Showing 1–9 of 14 results"; 
		AllProductsPage.firstPageValidation(input, text);
	}

	@Test(groups = "Integration Testing")
	public static void secondPageValidationTest() throws IOException {
		/*
		 => Validation 1: Total items (as of now) are 14, 
			-- First page will contained 9 items
			-- Second page will contained 5 items
		=> Validation 2: Current range is = 
		   	-- Showing 1–9 of 14 results, 
		    -- Showing 10–14 of 14 results 
		*/	
		int input = 5; // Based on scenario, validation Input either 9 or 5 
		String text = "Showing 10–14 of 14 results"; 
		AllProductsPage.secondPageValidation(input, text);
		//AllProductsPage.secondPageValidation(input,text);
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Driver is closed");
		driver.close();
	}

}
