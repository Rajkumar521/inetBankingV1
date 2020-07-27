package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getIepath() {
		String iePath = pro.getProperty("iepath");
		return iePath;
	}
	
	public String getFireFoxpath() {
		String fireFoxPath = pro.getProperty("firefoxpath");
		return fireFoxPath;
	}
}
