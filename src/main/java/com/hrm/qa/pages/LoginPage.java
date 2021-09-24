package com.hrm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:

	@FindBy(xpath="(//img)[1]")
	WebElement crmLogo;


	@FindBy(id="txtUsername")
	WebElement username;


	@FindBy(id="txtPassword")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;


	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}


	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}

	public boolean login(String type, String un, String pwd){

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		boolean result = true;
		
		String url = driver.getCurrentUrl();
		if(url.equals(prop.getProperty("loginpageauth")))
		{
	
			result = true;
		}
		else if(url.equals(prop.getProperty("homepageauth")))
		{
	
			result = true;	
		}
		else {
		
			result = false;
		}
		
		return result;

		
		
	}


}
