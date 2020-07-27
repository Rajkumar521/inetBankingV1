package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LogInPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logInTest() {
		
		
		LogInPage lp = new LogInPage(driver);
		
		lp.setUserName(username);
		Logger.info("Entered UserName");
		
		lp.setPassword(password);
		Logger.info("Entered Password");
		
		lp.clickSubmit();
		Logger.info("LogIn Successfully");
	
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("LogIn Test is Passed");
		}
		else
		{
			captureScreenshot(driver,"LogInTest");
			Assert.assertTrue(false);
			Logger.info("LogIn Test is Failed");
			
		}
	}
	
}
