package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions {
	public AndroidDriver driver;
	int countPrice;
	int maxAttempts = 5;
	int attempt = 0;
	double sum = 0, getProductPrice, getTotalPrice;
	String temporaryProductPrice, temporaryTotalPrice, getTermsTitle, getTermsMessage, expectedTermsTitle, 
	expectedTermsMessage;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement cartTitle;
	
	String getCartTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/totalAmountLbl\")")
	private WebElement totalPrice;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/termsButton\")")
	private WebElement termsButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	private WebElement termsTitle;
	
	@AndroidFindBy(id="android:id/message")
	private WebElement termsMessage;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement closeTermsBox;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement emailCheckButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement websiteButton;
	
	By readMoreElement = By.id("KByQx");
	By acceptAllElement = By.id("L2AGLb");

	public void checkCartTitle(String expectedValue) {
		waitForElementToAppear(10, cartTitle, "text", "Cart");
		getCartTitle = cartTitle.getText().trim();
		System.out.println("The title of cart page is: " + getCartTitle);
		Assert.assertEquals(getCartTitle, expectedValue);
	}
	
	public void checkTotalPrice() {
		countPrice = productPrice.size();
		for(int i = 0; i < countPrice; i++) {
			temporaryProductPrice = productPrice.get(i).getText().trim();
			getProductPrice = getFormattedAmount(temporaryProductPrice);
			sum = sum + getProductPrice;
		}
		System.out.println("The sum of the products is: " + sum);
		temporaryTotalPrice = totalPrice.getText().trim();
		getTotalPrice = getFormattedAmount(temporaryTotalPrice);
		System.out.println("The total price is: " + getTotalPrice);
		Assert.assertEquals(sum, getTotalPrice);
	}
	
	public void checkTerms() {
		longPressAction(termsButton);
		getTermsTitle = termsTitle.getText().trim();
		System.out.println("The title of terms is: " + getTermsTitle);
		getTermsMessage = termsMessage.getText().trim();
		System.out.println("The message of terms is: " + getTermsMessage);
		expectedTermsTitle = "Terms Of Conditions";
		expectedTermsMessage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
		Assert.assertEquals(getTermsTitle, expectedTermsTitle);
		Assert.assertEquals(getTermsMessage, expectedTermsMessage);		
		closeTermsBox.click();
	}
	
	public void receiveEmail() {
		emailCheckButton.click();
	}
	
	public void gotToWebSite() throws InterruptedException {
		websiteButton.click();
		
		// to get the contexts
	    Thread.sleep(1000);
		Set<String> context = driver.getContextHandles();
			  
		for(String contexts : context) { 
			System.out.println(contexts); 
		}
		 	
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		while (attempt < maxAttempts) {
			try {
				if (driver.findElement(readMoreElement).isDisplayed()) {
					driver.findElement(readMoreElement).click();
					Thread.sleep(500);
					attempt++;
					} else if (driver.findElement(acceptAllElement).isDisplayed()) {
						driver.findElement(acceptAllElement).click();
						break;
						} else {
							break;
							}
		         } catch (Exception e) {
		                e.printStackTrace();
		                }
		}
		
		driver.findElement(By.className("gLFyf")).sendKeys("GNU/Linux");
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
		
	}
	



}
