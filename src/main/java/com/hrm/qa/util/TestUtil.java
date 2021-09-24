package com.hrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.hrm.qa.base.TestBase;

public class TestUtil extends TestBase {

	
	//in test util you have to add code which we are going to use most commonly - EX- add cart xpath mostly remain same 
	//for all the pages //iframe switch frame code // excel sheet for @dataprovidee //screenshot code
	


	public static String TESTDATA_SHEET_PATH = "D:\\Eclipse_Project\\orangeHRMbyketan\\src\\main\\java\\com\\hrm\\testdata\\HRMtestdata.xlsx";

	static Workbook book;
	static Sheet sheet;


	public void switchToParentFrame() {
		driver.switchTo().defaultContent();
	}

	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sheet = book.getSheet(sheetName);
		
		
		//String[][] obj = new String[5][5];
		
		//array initilization
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			
			}
		}
		
		return data;
	}



	public static void takeScreenshotAtEndOfTest(String methodName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "D:\\Eclipse_Project\\orangeHRMbyketan\\screenshots\\" + methodName  + ".png";
		File dest = new File(path);
		FileHandler.copy(src, dest);
		System.out.println("Taking screenshot ... " + methodName);
	}

}


