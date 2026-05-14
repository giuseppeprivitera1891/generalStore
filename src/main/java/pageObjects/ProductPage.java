package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import utils.AndroidActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidActions {
	public AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement productTitle;
	
	String getProductTitle;
	
	public void checkProductTitle(String expectedValue) {
		waitForElementToAppear(5, productTitle, "text", "Products");
		getProductTitle = productTitle.getText();
		System.out.println("The title page is: " + getProductTitle);
		compareString(getProductTitle, expectedValue);
	}

}
