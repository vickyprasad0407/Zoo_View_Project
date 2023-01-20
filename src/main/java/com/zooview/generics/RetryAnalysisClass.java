package com.zooview.generics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class is used to retry the failed test script
 * @author Mr. Vicky
 *
 */
public class RetryAnalysisClass implements IRetryAnalyzer {

	int count=0;
	int retryLimit=4;
	public boolean retry(ITestResult result) {
		if (count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
