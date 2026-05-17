package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void longPressAction(WebElement ele) {
		// long press event
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		"elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
			        ".scrollIntoView(new UiSelector().text(\""+ text + "\"));"));
	}
		
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement)ele).getId(),
				   "direction", direction,
				   "percent", 0.75
				));
	}
		
	public void dragAction(WebElement ele, int x, int y) {
		// drag and drop element
		   ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
						   "elementId", ((RemoteWebElement) ele).getId(),
						   "endX", x,
						   "endY", y
			  ));
	}
		
}
