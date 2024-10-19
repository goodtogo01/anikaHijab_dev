package com.Base;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
	// Set Properties
	public static Properties prop;
	public static String projectPath = System.getProperty("user.dir");
	public static Logger log = LogManager.getLogger(); 
 	public static WebDriver driver;

    

	public Helper() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(projectPath + "/" + "config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public WebDriver initializations() {

		String browserName = prop.getProperty("browser");
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
				driver = new FirefoxDriver();
			} else {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// driver.manage().deleteAllCookies();
		//driver.get(prop.getProperty("url"));
		
		//cr.captureHttpRequests(driver, browserName);
		driver.get("https://anikahijab.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

		return getDriver();

	}

	public static WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return driver;
	}

}
