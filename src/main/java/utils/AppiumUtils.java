package utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	WebDriverWait wait;
	Double price;

	public void waitForElementToAppear(int time, WebElement element, String attribute, String value, AppiumDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public void compareString(String currentValue, String expectedValue) {
		Assert.assertEquals(currentValue, expectedValue);
	}
	
	public Double getFormattedAmount(String amount) {
		price = Double.parseDouble(amount.substring(1));
		return price;
	}
}
