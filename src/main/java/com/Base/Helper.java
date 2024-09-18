package com.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Utilities.CaptureRequests;
import com.Utilities.TestUtils;

import org.openqa.selenium.support.events.EventFiringDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
	// Set Properties
	public static Properties prop;
	public String projectPath = System.getProperty("user.dir");
	public static Logger log = LogManager.getLogger();
	CaptureRequests cr = new CaptureRequests();

	// set Drivers
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
		log.info("Initialization has started");
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
		driver.get(prop.getProperty("url"));
		//cr.captureHttpRequests(driver, browserName);
		// driver.get("https://anikahijab.com/");
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
