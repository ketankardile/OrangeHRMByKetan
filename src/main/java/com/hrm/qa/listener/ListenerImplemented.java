package com.hrm.qa.listener;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.util.TestUtil;



public class ListenerImplemented extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		System.out.println("Testing test case...." + result.getMethod());	
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case status : Passed : " + result.getName());	
		// TODO Auto-generated method stub
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getName();
		System.out.println("Test Case Status : Failed : " + methodName);
		
		try {
			TestUtil.takeScreenshotAtEndOfTest(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Skipped " + result.getName() + "\n" + result.getSkipCausedBy());	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}



	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Started for " + context.getName());	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test finished for " + context.getName());
	}



}