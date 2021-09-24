package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;


	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		loginPage.loginforother(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void verifyUserTab(){
		homePage.verifyUserTab();	
	}
	
	
	//https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
