package testUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	AndroidDriver driver;
	
	@BeforeClass
	public void configuration() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 8");
	    options.setChromedriverExecutable("//home//giuseppeprivitera//eclipse-workspace//generalStore//src//test//java//resources//chromedriver");
	    options.setApp("//home//giuseppeprivitera//eclipse-workspace//generalStore//src//test//java//resources//General-Store.apk");
			
	    driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement ele) {
		// long press event
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		"elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
		
	public void scrollToEnd() {
		// no prior idea
		boolean canScrollMore;
			
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			} while(canScrollMore);
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
		
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
		
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
 }


