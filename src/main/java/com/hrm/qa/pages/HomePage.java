package com.hrm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

@FindBy(xpath = "//img[@alt = 'OrangeHRM']")
WebElement Homepagelogo;

@FindBy(xpath = "(//a[@class = 'firstLevelMenu'])[1]")
WebElement admintab;

@FindBy(xpath = "(//a[@class = 'arrow'])[1]")
WebElement usermgmtab;


@FindBy(xpath = "((//ul[@id = 'mainMenuFirstLevelUnorderedList']//li)[1]//ul)[2]//li//a")
WebElement usertab;



	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomePageTitle(){
	return driver.getTitle();
	}
	
	
	public String verifyUserTab(){
		
		Actions act = new Actions(driver); 
		
		act.moveToElement(admintab).perform();
		act.moveToElement(usermgmtab).perform();
		act.moveToElement(usertab).click().perform();
		return driver.getCurrentUrl();
		
		
	}
	

}
