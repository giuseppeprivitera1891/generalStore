package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class FillPersonalData {
	public AndroidDriver driver;

	public FillPersonalData(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
