package com.inetBanking.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig config = new ReadConfig();
	

	public String baseUrl = config.getApplicationUrl();
	public String username = config.getUserName();
	public String password = config.getPassword();
	
	
	public static Logger Logger;
	public static WebDriver driver;
	
	@Parameters({"broswer"})
	@BeforeClass
	public void setUp(String br) {
	
		if(br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities cap = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		driver = new ChromeDriver(options);		
		options.merge(cap);
		}else 
			if(br.equals("ie")){
			System.setProperty("webdriver.chrome.driver",config.getIepath());
			driver = new InternetExplorerDriver();
		}else 
			if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",config.getFireFoxpath());
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(baseUrl);;
		
		Logger  = org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
//		Thread.sleep(50000);
		driver.quit();
	}
	
	public static void captureScreenshot(WebDriver driver , String screenshot_name) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/"+screenshot_name+".png"));
			System.out.println("ScreenShot Taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String randomString() {
		String random_String = RandomStringUtils.randomAlphabetic(5);
		return(random_String);
	}
	
	public static String randomNum(int num) {
		String random_num = RandomStringUtils.randomNumeric(num);
		return (random_num);
	}

	
}
