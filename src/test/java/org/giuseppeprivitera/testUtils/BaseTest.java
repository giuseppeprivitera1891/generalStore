package org.giuseppeprivitera.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.giuseppeprivitera.pageObjects.InformationPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;
	UiAutomator2Options options;
	public InformationPage informationPage;
	String uri, androidDeviceName;
	
	@BeforeClass
	public void configuration() throws URISyntaxException, IOException {
		Properties prop = new Properties();
		// it reads the properties from 'data.properties' file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"//src//main//java//org//giuseppeprivitera//resources//data.properties");
		
		// it loads the file
		prop.load(fis);
		uri = prop.getProperty("uri");
		androidDeviceName = prop.getProperty("androidDeviceName");
		
		// it creates an instance of UiAutomaor2Options
		options = new UiAutomator2Options();
		options.setDeviceName(System.getProperty("androidDeviceName"));
		options.setChromedriverExecutable(System.getProperty("user.dir") + "//src//test//java//"
				+ "org//giuseppeprivitera//resources//chromedriver");
	    options.setApp(System.getProperty("user.dir") + "//src//test//java//org//giuseppeprivitera//resources//"
	    		+ "General-Store.apk");
	    
	    driver = new AndroidDriver(new URI(prop.getProperty("uri")).toURL(), options);
	    
	    // it creates the InformationPage instance
	    informationPage = new InformationPage(driver);
	}
		
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
 }


