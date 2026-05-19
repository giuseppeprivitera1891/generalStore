package utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	WebDriverWait wait;
	double price;

	public void waitForElementToAppear(int time, WebElement element, String attribute, String value, AppiumDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public void compareString(String currentValue, String expectedValue) {
		Assert.assertEquals(currentValue, expectedValue);
	}
	
	public double getFormattedAmount(String amount) {
		price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void getContext(AndroidDriver driver) {
		// it gets the contexts
		Set<String> context = driver.getContextHandles();
			  
		for(String contexts : context) { 
			System.out.println(contexts); 
		}
	}
}
