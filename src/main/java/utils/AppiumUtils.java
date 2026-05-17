package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	AppiumDriver driver;

	public AppiumUtils(AppiumDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(int time, WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public void waitForTextToAppear(int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void compareString(String currentValue, String expectedValue) {
		Assert.assertEquals(currentValue, expectedValue);
	}
	
	public void verifyCheckedButton(WebElement element) {
		element.isSelected();
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
}
