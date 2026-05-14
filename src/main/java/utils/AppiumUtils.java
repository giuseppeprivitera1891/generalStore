package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	AndroidDriver driver;

	public AppiumUtils(AndroidDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void compareString(String currentValue, String expectedValue) {
		Assert.assertEquals(currentValue, expectedValue);
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
}
