package com.inetBanking.pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EditCustomer {
	
	WebDriver ldriver;
	public static Logger logger;
	
	
	
	public EditCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		 logger = Logger.getLogger("EditCustomer");
			PropertyConfigurator.configure("log4j.properties");
	}
	
	public void edit_Customer() {
		ldriver.findElement(By.xpath("//a[@href='EditCustomer.php']")).click();
	}
	
	
	
	
	public void SetCustomerId(String custId) {
		ldriver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(custId);
		logger.info("Cust Id is Entered");
	}
	
	public void idsubmit() {
		ldriver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		logger.info("Cust Id is Submitted");
	}
	
	public void idReset() {
		ldriver.findElement(By.xpath("//input[@name='res']")).click();
	}
	
	public void Continue() {
		ldriver.findElement(By.xpath("//td//a[@href='Managerhomepage.php']")).click();
		logger.info("Continue button clicked");
	}
	
	public void HomeButton() {
		ldriver.findElement(By.xpath("//p//a[@href='Managerhomepage.php']")).click();
		logger.info("Cust Id is Reseted");
	}
	
	
	
	
	
	public void set_Name(String Name) {
	WebElement name=ldriver.findElement(By.name("name"));
		
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
		WebElement adr = ldriver.findElement(By.name("addr"));
		adr.clear();
		adr.sendKeys(Address);
		logger.info("Customer Address changed");
	}
	
	public void set_City(String City) {
		WebElement city = ldriver.findElement(By.name("city"));
		city.clear();
		city.sendKeys(City);
		logger.info("Customer city changed");
	}
	
	public void set_State(String State) {
		WebElement state = ldriver.findElement(By.name("state"));
		state.clear();
		state.sendKeys(State);
		logger.info("Customer State changed");
	}
	
	public void set_Pin(String Pincode) {
		WebElement pin = ldriver.findElement(By.name("pinno"));
		pin.clear();
		pin.sendKeys(Pincode);
		logger.info("Customer Pincode changed");
	}
	
	public void set_MobNum(String MobileNumber) {
		WebElement mob = ldriver.findElement(By.name("telephoneno"));
		mob.clear();
		mob.sendKeys(MobileNumber);
		
		logger.info("Customer MobileNum changed");
	}
	
	public void set_EmailId(String Email) {
		WebElement email = ldriver.findElement(By.name("emailid"));
		email.clear();
		email.sendKeys(Email);
	}
	
	public void set_Password(String password) {
		WebElement pwd = ldriver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);;
		
		logger.info("Customer EmailID changed");
	}
	
	public void Submit() {
		ldriver.findElement(By.xpath("//input[@value='Submit']")).click();
		logger.info("Changed Values are submitted");
	}
	
	public void Reset() {
		ldriver.findElement(By.xpath("//input[@value='Reset']")).click();
		logger.info("Values are Reseted");
	}
	
	
	
	//a[@href='EditCustomer.php']

}
