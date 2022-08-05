package com.inetbanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	// need to create a properties object and need to create a constructor to read
	// files and then create method
	// for the properties file variable
	Properties pro;

	public ReadConfig() {

		File src = new File("./Configueration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicantionURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}

	public String getPassword() {
		String Password = pro.getProperty("password");
		return Password;

	}

	public String getChromepath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;

	}

	public String getIepath() {
		String iePath = pro.getProperty("iepath");
		return iePath;

	}

	public String getFirefoxpath() {
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;

	}

}
