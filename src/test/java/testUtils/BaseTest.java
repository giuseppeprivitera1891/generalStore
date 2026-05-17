package testUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;
	
	@BeforeClass
	public void configuration() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 8");
	    options.setChromedriverExecutable("//home//giuseppeprivitera//eclipse-workspace//generalStore//src//test//java//resources//chromedriver");
	    options.setApp("//home//giuseppeprivitera//eclipse-workspace//generalStore//src//test//java//resources//General-Store.apk");
	    options.setCapability("browserName", "Chrome");   
	    
	    driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
 }


