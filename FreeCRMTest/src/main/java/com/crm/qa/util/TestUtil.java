package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	 public static long page_Load_TimeOut = 20;
	 public static long implicit_wait = 10;
	 static Workbook book;
	 static Sheet sheet;
	 
	 static String sheetPath = "/Users/arpan/git/PractiseFramework/FreeCRMTest/src/main/Resources/CRMTestData.xlsx" ;
	 public void switchToFrame()  {
		driver.switchTo().frame("mainpanel");
	}
	 
	 public static Object[][] getTestData(String sheetName) {
		 FileInputStream file =null;
		 try {
			file = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  sheet =  book.getSheet(sheetName);
		 
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i = 0; i<sheet.getLastRowNum();i++) {
			 for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
				 data[i][j]= sheet.getRow(i+1).getCell(j).toString(); 
			 }
		 }		 
		 return data;
	 }
	 
	 public static void captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		FileUtils.copyFile(srcFile, new File(userDir+"/screenshots/"+System.currentTimeMillis()+".png"));
		
	 }
}
