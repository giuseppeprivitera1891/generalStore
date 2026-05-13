package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		String productTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText().trim();
		Assert.assertEquals(productTitle, "Products");
		
		List<WebElement> textProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		String myProduct = "Jordan 6 Rings";

		// it searches the product in the list
		for (WebElement product : textProducts) {
		    if (product.getText().equalsIgnoreCase(myProduct)) {
		        driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		        System.out.println("Product found and added in the cart: " + myProduct);
		        return; // it exits from the cycle when finds the product
		    }
		}

		// if the product is not visible, it scrolls and tries again
		scrollToText(myProduct);

		// after the scroll, it repeats the research
		textProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for (WebElement product : textProducts) {
		    if (product.getText().equalsIgnoreCase(myProduct)) {
		        driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		        System.out.println("Product found after the scroll and added in the cart: " + myProduct);
		        return;
		    }
		}

		// if it do not find the product
		System.out.println("Product not found: " + myProduct);
	
		String getNumberOfArticle = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText().trim();
		Assert.assertEquals(getNumberOfArticle, "1");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
	}
}
		

		
	
		  
	
	
	
	

	


		
		
		

			



