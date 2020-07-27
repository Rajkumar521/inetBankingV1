package com.inetBanking.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomer;
import com.inetBanking.pageObjects.LogInPage;

public class TC_NewCust_003 extends BaseClass{

	@Test
	public void addCustomer() throws InterruptedException {
		LogInPage lp = new LogInPage(driver);
		lp.setUserName(username);
		Logger.info("UserName Provided");
		lp.setPassword(password);
		Logger.info("Password Provided");
		lp.clickSubmit();
		Logger.info("Submited");
		lp.DashBoard();
		
		Thread.sleep(5000);
		
		AddNewCustomer ad = new AddNewCustomer(driver);
		
		Logger.info("!-----Providig the Customer Details-----!");
		ad.click_NewCustomer();
		
		String random1 = randomString();
		ad.set_Name(random1);
		ad.set_Gender();
		ad.set_DOB("25","5","1997");
		Thread.sleep(3000);
		ad.set_Adr("Sri Balaji Mens Hostel Near Swatchi High school");
		ad.set_City("Madhapur");
		ad.set_State("Telangana");
		ad.set_Pin("500081");
		ad.set_MobNum("1234567890");
		
		String email =	randomString()+"@gmail.com";
		ad.set_EmailId(email);
		
		ad.set_Password("123456");
		ad.set_Submit();
		Logger.info("Details Submitted");
		Thread.sleep(3000);

				
		String act_str =driver.findElement(By.xpath("//p[@class='heading3']")).getText(); 

		System.out.println(act_str);
	
		String Exp_str = "Customer Registered Successfully!!!";
		
		
		Assert.assertEquals(act_str, Exp_str,"Test Case failed");
		Logger.info("TestCase Passed");

	
	}
	
	
	
	
	
}
