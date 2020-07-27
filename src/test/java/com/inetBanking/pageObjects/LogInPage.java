package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	WebDriver ldriver;
	
	public LogInPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, ldriver);
	}
	
	
//	@FindBy(name="uid")
//	WebElement txttUserName;
//	
//	@FindBy(name="password")
//	@CacheLookup
//	WebElement txtpassword;
//	
//	@FindBy(name="btnLogin")
//	@CacheLookup
//	WebElement btnLogin;
	
	
	public void setUserName(String username) {
//		txttUserName.sendKeys(username);
		ldriver.findElement(By.name("uid")).sendKeys(username);
	}
	
	public void setPassword(String password) {
//		txtpassword.sendKeys(password);
		ldriver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void clickSubmit() {
		ldriver.findElement(By.name("btnLogin")).click();
//		btnLogin.click();
	}
	
	public void DashBoard() {
		String welcome = ldriver.findElement(By.xpath("//marquee[@class='heading3' and @behavior='alternate']")).getText();
		System.out.println(welcome);
	}
	public void Logout() {
		ldriver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}
	
	
}
