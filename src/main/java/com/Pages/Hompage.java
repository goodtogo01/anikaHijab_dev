package com.Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Base.Helper;
import com.Utilities.TestUtils;

public class Hompage extends Helper {
	/**
	 * Author Khosurz zaman Target of ths class: to gather all necessary webelement
	 * identifires using several locators technique
	 * 
	 * 
	 */
	// Locators
	 @FindBy(xpath = "//*[@id='primary-site-navigation']/div")
	public
	 WebElement menu_List;
	
	String all_Manue_List_from_headers = "//*[@id='primary-site-navigation']/div";

	@FindBy(linkText = "Home")
	WebElement home_Manu;

	@FindBy(linkText = "All Products")
	WebElement products_manue;

	@FindBy(linkText = "Scarf")
	WebElement scarf_Manu;

	@FindBy(linkText = "Under Cap")
	WebElement under_Cap_Manu;

	@FindBy(linkText = "Scarf Pin")
	WebElement scarf_Pin_Manu;

	@FindBy(linkText = "About")
	WebElement about_Manu;

	@FindBy(linkText = "Contact")
	WebElement contact_Manu;
	
	//Drop Down menu
	String dropDownList = "//*[@id='menu-item-470']/ul";	 
	String myAccountLink = "My account";
	String accounts = "Account";

	
	
//Page Factory Initializations
	public Hompage() {
		PageFactory.initElements(driver, this);
	}

// Main Page Title
	public String validatePageTitle(String expected_Title) {
		String originalTitle = driver.getTitle();
		System.out.println("The Page Title is : " + originalTitle);
		Assert.assertEquals(expected_Title, originalTitle, "Title is missing!!");
		return originalTitle;
	}

// Validate List of header Manue
	public void headerManue(String manuName) {
		List<WebElement> t = driver.findElements(By.xpath(all_Manue_List_from_headers));
		for (int i = 0; i < t.size(); i++) {
			System.out.print("List of Items ar: " + t.get(i).getText().toString() + " ");
			if (t.get(i).getText().contains(manuName)) {
				System.out.println("\nIs Available.");
				break;
			} else {
				System.out.println("\nIs not Available.");

			}

		}
	}

// Validate Home menu from Header List
	public void homeManuDisplayed() {
		String actualValue = home_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(home_Manu.isDisplayed(), " Is not Displayed.");
	}

// Validate All Products menu from Header List
	public void productsMenueDisplayed() {
		String actualValue = products_manue.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(products_manue.isDisplayed(), " Is not Displayed.");
	}

// Validate Scarf Menu from header list
	public void scarfManuDisplayed() {
		String actualValue = scarf_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(scarf_Manu.isDisplayed(), " Is not Displayed.");
	}

// Validate Under Cap menu from Header List
	public void underCapManuDisplayed() {
		String actualValue = under_Cap_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(under_Cap_Manu.isDisplayed(), " Is not Displayed.");
	}

// Validate Scarf Pin Menu from header list
	public void scarfPinManuDisplayed() {
		String actualValue = scarf_Pin_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(scarf_Pin_Manu.isDisplayed(), " Is not Displayed.");
	}

// Validate About menu from Header List
	public void aboutMenueDisplayed() {
		String actualValue = about_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(about_Manu.isDisplayed(), " Is not Displayed.");
	}

// Validate contact menu from Header List
	public void contactMenueDisplayed() {
		String actualValue = contact_Manu.getText();
		System.out.println(actualValue + " is Displayed. ");
		Assert.assertTrue(contact_Manu.isDisplayed(), " Is not Displayed.");
	}
//Validate Account menu
	public void validateAccountMenu() {
	WebElement el = driver.findElement(By.linkText(accounts));
	Actions action = new Actions(driver);
	action.moveToElement(el).perform();
	//driver.findElement(By.linkText(myAccountLink)).click();
	List<WebElement> we = driver.findElements(By.xpath(dropDownList));
	for(int i = 0; i<we.size(); i++) {
		System.out.println(we.get(i).getText()+" ");
		assertTrue(we.get(i).isDisplayed(), "\nItems not available.");
		}	
	}

// Validate Home Page Body
	

}
