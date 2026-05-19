package testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.InformationPage;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public InformationPage informationPage;
	String uri, androidDeviceName;
	
	@BeforeClass
	public void configuration() throws URISyntaxException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
		
		prop.load(fis);
		uri = prop.getProperty("uri");
		androidDeviceName = prop.getProperty("androidDeviceName");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(System.getProperty("androidDeviceName"));
		options.setChromedriverExecutable(System.getProperty("user.dir") + "//src//test//java//resources//chromedriver");
	    options.setApp(System.getProperty("user.dir") + "//src//test//java//resources//General-Store.apk");
	    
	    driver = new AndroidDriver(new URI(prop.getProperty("uri")).toURL(), options);
	 //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    informationPage = new InformationPage(driver);
	}
		
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
 }


