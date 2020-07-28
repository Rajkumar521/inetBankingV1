package com.inetBanking.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomer;
import com.inetBanking.pageObjects.LogInPage;

public class TC_EditCust__004 extends BaseClass {
	
	@Test
	public void EditCust() {
		LogInPage lp = new LogInPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		String act = driver.getTitle();
		System.out.println();
		String exp = "Guru99 Bank Manager HomePage";
//		boolean titile = driver.getTitle().equalsIgnoreCase("");
		Assert.assertEquals(act,exp,"Title is not matched");
		Logger.info("logIn Succesfully");
		
		EditCustomer ed = new EditCustomer(driver);
		ed.edit_Customer();
		
		ed.SetCustomerId("59577");
		
		ed.idsubmit();
		
		ed.set_Adr("Sri Balaji Mens hostel Ayyappa society");
		ed.set_City("Rajamahedravaram");
		ed.set_State("Andhra Pradesh");
		
		String pin = randomNum(6);
		ed.set_Pin(pin);
		
		String mobnum = randomNum(10);
		ed.set_MobNum(mobnum);
		
		String email = randomString()+"@gmail.com";
		ed.set_EmailId(email);
		
		ed.Submit();
		
		BaseClass.captureScreenshot(driver,"Changedcust_details");
		String act_str =driver.findElement(By.xpath("//p[@class='heading3']")).getText();
		System.out.println(act_str);
		String Exp_str = "Customer details updated Successfully!!!";
		
		Assert.assertEquals(act_str, Exp_str,"Test Case failed");
		Logger.info("TestCase Passed");
		
		ed.Continue();
		WebElement managerpage = driver.findElement(By.className("heading3"));
		
		String act1 = managerpage.getText();
		
		String exp1 = "Welcome To Manager's Page of Guru99 Bank";
		
		Assert.assertEquals(act1,exp1,"Page is not navigated to Manager Page");
		Logger.info("Succesfully navigated to Manager Page");
	}	

}
