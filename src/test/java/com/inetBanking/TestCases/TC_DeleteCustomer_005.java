package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeleteCustomer;
import com.inetBanking.pageObjects.LogInPage;

public class TC_DeleteCustomer_005 extends BaseClass {

	@Test
	public void DeleteCust() {
		
		LogInPage lp = new LogInPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		DeleteCustomer del = new DeleteCustomer(driver);
		del.delCustomerId("67607");
		del.idsubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.info("customer is not deleted");
		}else {
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Logger.info("Customer is deleted Succesfullt");
		}

		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
