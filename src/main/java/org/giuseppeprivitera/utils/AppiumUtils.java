package org.giuseppeprivitera.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	WebDriverWait wait;
	double price;
	File source;
	String destinationFile;

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
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		source = driver.getScreenshotAs(OutputType.FILE);
		destinationFile = System.getProperty("user.dir") + "//reports//screenshots//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
