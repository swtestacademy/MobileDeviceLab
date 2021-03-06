package com.automation.testapp.configuration;

import java.io.IOException;
import java.util.Properties;

public class TestAppConfiguration {

	private static TestAppConfiguration instance;
	private static Object lock = new Object();
	private String appActivity;
	private String appPackage;
	private String standartID;
	private String appiumURL;
	private String movieName;
	private String userName;
	private String password;
	private String user;

	private TestAppConfiguration() {
	}

	public static TestAppConfiguration GetInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new TestAppConfiguration();
					instance.LoadData();
				}
			}
		}

		return instance;

	}

	private void LoadData() {
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("dmsConfiguration.properties"));
		} catch (IOException e) {
			System.out.println("Properties file cannot be found");
		}
		;
		appPackage = prop.getProperty("appPackage");
		appiumURL = prop.getProperty("appiumURL");
		appActivity = prop.getProperty("appActivity");
		movieName = prop.getProperty("movieName");
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");
		user = prop.getProperty("user");
	}



	public String getAppActivity() {
		return appActivity;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public String getStandartID() {
		return standartID;
	}

	

	public String getAppiumURL() {
		return appiumURL;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}
}
