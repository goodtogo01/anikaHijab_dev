package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.Helper;

import io.qameta.allure.Lead;

public class TestUtils extends Helper{
	//static WebDriver driver;
	public static final int IMPLICITLY_WAIT_TIME = 30;
	public static final long PAGE_LOAD_TIME = 10;
	public static WebDriverWait wait;
	public static String TestDataSheet =System.getProperty("user.dir");
	static Workbook book;
	static Sheet sheet;
	public static Alert alert; 
	public static FileInputStream fis;
	public static boolean flag = false;
	
	public static Object[][] getTestData(String sheetName){
		try {
			fis = new FileInputStream(TestDataSheet+"/"+"salesSheet.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + " Row's and ================= " + sheet.getRow(1).getLastCellNum()
				+ " Column === ");
		for(int i =0; i<sheet.getLastRowNum(); i++) {
			for(int j =0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString(); //i + 1 = Cell 0
				System.out.print(data[i][j]+", ");
			}
		}
	return data;
	}

	public static WebElement javaScriptExecutor(String element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(element, "Java Scripts has executed.");
		return null;
	}
	public static void takeScreenShoot() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(curentDir + "/Screen_Shoot/" + System.currentTimeMillis() + ".png"));

	}
	public static void takeScreenShootSpecificElement(WebElement element) throws IOException {
		File screenShotFile = element.getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(screenShotFile, new File(curentDir + "/Screen_Shoot/" + System.currentTimeMillis() + ".png"));
		System.out.println("Screenshot has taken and ready to view ....");
	}
	public static void explicitelyWaitTime(String locator) {
		// wait = new WebDriverWait(driver, IMPLICITLY_WAIT_TIME);
		WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}
	public static void implicitelyWaitTime() throws InterruptedException {
		// selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 
	 
	}
//	public static void implicitelyWaitTimeForAlert() {
//		wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.alertIsPresent());
//	}
	
	public static void selectClass(String listOfHead, String items) {
		Select select = new Select(driver.findElement(By.xpath(listOfHead)));
		List<WebElement> element = select.getOptions();
		System.out.println("List Of Items ar: ");
		for(int i =0; i<element.size(); i++) {
			String listOfElements = element.get(i).getText();
			System.out.println(listOfElements);
	}
		select.selectByVisibleText(items);
		System.out.println("Selected with following cetegory: "+items.toString());
		
		
		
		//System.out.println("List of Items are : "+se.getAllSelectedOptions());
	}
	public static void alertMethod(String allertButton) {
		System.out.println("Prompt Alert.");
		WebElement element = ((WebDriver) driver).findElement(By.id(allertButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		alert = ((WebDriver) driver).switchTo().alert();
		String text2 = alert.getText();
		System.out.println("Alert Text : " + text2);
		alert.accept();
		
		//alert.sendKeys("Khosruz zaman");
	}
	
	public static void start_Docker() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start start_DockerGrid.bat");
		Thread.sleep(3000);
	}
	
	public static void stop_Docker() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c close_DockerGrid.bat");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //close cmd
	}

	 

	
}
