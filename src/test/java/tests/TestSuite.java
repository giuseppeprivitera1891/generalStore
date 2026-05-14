package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FillInformationPage;
import testUtils.BaseTest;

public class TestSuite extends BaseTest {
	String country = "Argentina";
	String name = "Klaudia Mondelez";
	String gender = "Female";
	String myProduct = "Jordan 6 Rings";
	
	@Test
	public void runSuite() {
		//driver.findElement(By.id("android:id/text1")).click();
		//scrollToText(country);
		//driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + country + "\")")).click();
		FillInformationPage fillInformation = new FillInformationPage(driver);
		fillInformation.selectCountry(country);
		fillInformation.setName(name);
		fillInformation.setGender(gender);
		fillInformation.goToProductPage();
		
		// product page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		String productTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText().trim();
		Assert.assertEquals(productTitle, "Products");
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		scrollToText(myProduct);

		for(int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase(myProduct)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				System.out.println("The product chose is: " + productName);
			}
		}
	
		String getNumberOfArticle = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText().trim();
		Assert.assertEquals(getNumberOfArticle, "1");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		String cartTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText().trim();
		Assert.assertEquals(cartTitle, "Cart");
		
		
	}
}
		

		
	
		  
	
	
	
	

	


		
		
		

			



