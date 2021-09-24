package com.hrm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;



	public LoginPageTest(){	
		super();
	}


	@BeforeMethod
	public void setUp(){

		initialization();
		loginPage = new LoginPage();	
	}


	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}


	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}





	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	
	
	}

	
	@Test(priority = 3, dataProvider="getCRMTestData")
	public void validateLogin(String type, String username, String pass){
		boolean result = loginPage.login(type, username, pass);
		Assert.assertTrue(result);	
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		driver.quit();
	}





}
