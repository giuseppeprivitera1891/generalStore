package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import testUtils.BaseTest;

public class TestSuite extends BaseTest {
	String country = "Argentina";
	
	@Test
	public void runSuite() {
		driver.findElement(By.id("android:id/text1")).click();
		scrollToText(country);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + country + "\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// product page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		
		
		
			
			
	}

}
