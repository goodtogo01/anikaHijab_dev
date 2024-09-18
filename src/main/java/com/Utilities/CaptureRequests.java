package com.Utilities;

import java.util.Optional;

import org.apache.hc.client5.http.entity.mime.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
 
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 

public class CaptureRequests extends Header {
	DevTools devTools;

	public void captureHttpRequests(WebDriver driver, String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			devTools = ((ChromeDriver) driver).getDevTools();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			devTools = ((FirefoxDriver) driver).getDevTools();
			System.out.println("FireFox driver is not published yet!!");
		} else if (browserName.equalsIgnoreCase("edge")) {
			devTools = ((EdgeDriver) driver).getDevTools();
		}
		
//		devTools.createSession();
//		
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		devTools.addListener(Network.requestWillBeSent(), 
//				entry-> {
//					System.out.println("Request URL : "+entry.getRequest().getUrl());
//					System.out.println("Request Type : "+entry.getRequest().getMethod());
//				});
	}
}
