package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.Helper;
import com.Utilities.TestUtils;

public class ScarfPage extends Helper {

	// Get all elements identifires
	
	@FindBy(linkText = "Scarf")
	WebElement scraf_manue;
	
	
	@FindBy(xpath = "//div[@xpath='1']")
	WebElement scarfLogo;
	
	//Item Displayed
	static String totalDisplayed = "//*[@class='products columns-3']/li"; // Basic operation
 
	
	//*[@id="post-4469"]/div/div[4]/div/section/div/div/div/div[3]/div/div/div/ul

	public ScarfPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToScarfPage() {
		scraf_manue.click();
	}

	public String validatePageTitle(String expected_Title) {
		String originalTitle = driver.getTitle();
		System.out.println("The Page Title is : " + originalTitle);
		Assert.assertEquals(expected_Title, originalTitle, "Title is missing!!");
		return originalTitle;
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
}