package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, ldriver);
	}
	
	public void click_NewCustomer() {
		ldriver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();
	}
	
	
	public void set_Name(String Name) {
		ldriver.findElement(By.name("name")).sendKeys(Name);
	}
	
	public void set_Gender() {
		ldriver.findElement(By.xpath("//tr[5]//td[2]//input[1]")).click();
	}

	public void set_DOB(String dd,String m,String yyyy) {
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dd);
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(m);
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.TAB).perform();
		
		ldriver.findElement(By.xpath("//input[@id='dob']")).sendKeys(yyyy);
	}
	
	public void set_Adr(String Address) {
		ldriver.findElement(By.name("addr")).sendKeys(Address);
	}
	
	public void set_City(String City) {
		ldriver.findElement(By.name("city")).sendKeys(City);
	}
	
	public void set_State(String State) {
		ldriver.findElement(By.name("state")).sendKeys(State);
	}
	
	public void set_Pin(String Pincode) {
		ldriver.findElement(By.name("pinno")).sendKeys(Pincode);
	}
	
	public void set_MobNum(String MobileNumber) {
		ldriver.findElement(By.name("telephoneno")).sendKeys(MobileNumber);
	}
	
	public void set_EmailId(String Email) {
		ldriver.findElement(By.name("emailid")).sendKeys(Email);
	}
	
	public void set_Password(String password) {
		ldriver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void set_Submit() {
		ldriver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	public void set_Reset() {
		ldriver.findElement(By.xpath("//input[@value='Reset']")).click();
	}
	
}
