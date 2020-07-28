package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomer {

	
	WebDriver ldriver;
	public DeleteCustomer(WebDriver rdriver) {
		ldriver = rdriver;
	}
	
	
	public void delCustomerId(String custId) {
		ldriver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(custId);
	}
	
	public void idsubmit() {
		ldriver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	}
	
	public void idReset() {
		ldriver.findElement(By.xpath("//input[@name='res']")).click();
	}
	
}
