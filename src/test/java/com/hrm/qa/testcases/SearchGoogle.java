package com.hrm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SearchGoogle {




	@Test	
	public void Search() {


		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://www.google.com/");

		WebElement obj = driver.findElement(By.xpath("//input[@title = 'Search']"));

		obj.sendKeys("hello");

		driver.findElement(By.xpath("(//input[@name = 'btnK'])[2]")).click();




	}


}
