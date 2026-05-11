package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import testUtils.BaseTest;

public class TestSuite extends BaseTest {
	
	@Test
	public void runSuite() {
		driver.findElement(By.id("android:id/text1")).click();
		scrollToText("Argentina");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		
	}

}
