package pageObjects;

import java.util.List;

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
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productList;
	
	int countProduct;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartButton;
	
	public void checkProductTitle(String expectedValue) {
		waitForElementToAppear(10, productTitle, "text", "Products");
		getProductTitle = productTitle.getText();
		System.out.println("The title page is: " + getProductTitle);
		compareString(getProductTitle, expectedValue);
	}
	
	public void selectProduct(String chooseProduct) {
		scrollToText(chooseProduct);
		for(int i = 0; i < countProduct; i++) { 
			String productName = productList.get(i).getText();
			if(productName.equalsIgnoreCase(chooseProduct)) {
				addToCartButton.get(i).click();
				System.out.println("The product chose is: " + productName);
				} 
			}
	}

}
