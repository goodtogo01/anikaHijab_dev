package com.Pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.Base.Helper;
import com.Utilities.TestUtils;


public class LoginPage extends Helper {

	// Locators

	// Drop down to select my account link
	// Drop Down menu
	String dropDownList = "//*[@id='menu-item-470']/ul";
	String myAccountLink = "My account";
	String accounts = "Account";

	@FindBy(xpath = "//input[@id='username']")
	WebElement typeUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement typePassword;

	@FindBy(xpath = "//input[@id='rememberme']")
	WebElement checkRememberMe;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement buttonLogin;

	@FindBy(linkText = "Lost your password?")
	WebElement forgetPassword;

	@FindBy(xpath = "//*[contains(text(),'Hello')]") // "//*[@id='post-99']/div/div[4]/div/p[1]")
	WebElement validateWelcomeMessage;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOutButton;

	@FindBy(xpath = "//h1[contains(text(),'My account')]")
	WebElement backToLoginPage;
	
	@FindBy(xpath = "//main[@id='main']")
	WebElement backToLogin;

	// Initialize constractor with Helper(super) class
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//Navigatge to Account page
	public void goToAccountPage() {
		WebElement el = driver.findElement(By.linkText(accounts));
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
		driver.findElement(By.linkText(myAccountLink)).click();
	}

//Page Title
	public String validatePageTitle(String expected_Title) {
		String originalTitle = driver.getTitle();
		System.out.println("The Page Title is : " + originalTitle);
		Assert.assertEquals(expected_Title, originalTitle, "Title is missing!!");
		return originalTitle;
	}

//clickable option
	public void rememberMe() {
		if (checkRememberMe.isDisplayed()) {
			checkRememberMe.click();
			System.out.println("It was Displayed previously and click on it.");
		} else {
			System.out.println("It is not Displaying.");
		}
	}

// Logins functions
	public void loginWithValidCredentials(String user, String password) {
		typeUserName.sendKeys(user);
		typePassword.sendKeys(password);
		rememberMe();
		buttonLogin.click();

	}

	public void validateLoginMessages() {

		boolean hello = validateWelcomeMessage.isDisplayed();
		if (hello == true) {
			System.out.println("Found as expected value : " + validateWelcomeMessage.getText());
		} else {
			System.out.println("No Welcome message found!!");
		}
		assertTrue(hello, "Assertion doesnt match!!!");
	}

	public void backToLoginPageAgain() {
		boolean display = backToLoginPage.isDisplayed();
		if(display == true) {
			System.out.println("Successfully Log out and Back to the SignIn Page.");
			System.out.println("Login my account page as : "+backToLoginPage.getText());
		}
		
		assertTrue(display, "Unable to back to the login page again.");
	}
	
	public void logOut() throws IOException {
		logOutButton.click();
		TestUtils.takeScreenShootSpecificElement(backToLogin);
		backToLoginPageAgain();
	}
}
