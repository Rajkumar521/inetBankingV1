package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LogInPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LogInDT_002 extends BaseClass{

	@Test(dataProvider = "LogIndata")
	public void LogInDDT(String user,String pwd) throws InterruptedException {
		LogInPage lp = new LogInPage(driver);
		lp.setUserName(user);
		Logger.info("Entered UserName");
		lp.setPassword(pwd);
		Logger.info("Entered Password");
		lp.clickSubmit();

		
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.info("Login failed");
		}else {
			Assert.assertTrue(true);
			Logger.info("Logoin Passed");
			Thread.sleep(3000);
			lp.Logout();
			Logger.info("Logout Successfully");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
	}catch(NoAlertPresentException e) {
		return false;
	}
	}
	
	@DataProvider(name = "LogIndata")
	String [][] getData() throws IOException{
		String path = "C:\\Users\\rajku\\Downloads\\Untitled spreadsheet.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int celcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String LoggingData[][]=new String[rowcount][celcount];
		
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<celcount;j++) {
				LoggingData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return LoggingData;
	}
}
