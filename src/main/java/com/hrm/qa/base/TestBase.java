package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {

		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Eclipse_Project\\orangeHRMbyketan\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			prop.load(ip);


		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	public static void initialization() {

		String browserType = prop.getProperty("browser");
		


		if (browserType.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_Project\\orangeHRMbyketan\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserType.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_Project\\orangeHRMbyketan\\Drivers\\geckodriver.exe" );
			driver = new FirefoxDriver();
			
		}

	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	
	}



}








