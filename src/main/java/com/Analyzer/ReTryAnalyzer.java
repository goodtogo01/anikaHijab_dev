package com.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int limit = 2;
	
	public boolean retry(final ITestResult result) {
		if(counter < limit) {
			counter++;
			return true;
		}
		return false;
	}

}
