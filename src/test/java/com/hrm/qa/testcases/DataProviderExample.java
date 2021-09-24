package com.hrm.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.util.TestUtil;

public class DataProviderExample {



	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}


	@Test(priority = 2, dataProvider="getCRMTestData")
	public void validateLogin(String abc, String username, String pass){

		System.out.println(username + "" + pass);
	
	
	
	
	}

}
