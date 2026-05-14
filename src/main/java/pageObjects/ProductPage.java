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
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/counterText")
	private WebElement numberOfArticle;
	
	String getNumberOfArticle; 
	
	public void checkProductTitle(String expectedValue) {
		waitForElementToAppear(10, productTitle, "text", "Products");
		getProductTitle = productTitle.getText();
		System.out.println("The title page is: " + getProductTitle);
		compareString(getProductTitle, expectedValue);
	}
	
	public void selectProduct(String chooseProduct) {
		countProduct = productList.size();
		scrollToMultipleTexts(chooseProduct);
		for(int i = 0; i < countProduct; i++) { 
			String productName = productList.get(i).getText();
			if(productName.equalsIgnoreCase(chooseProduct)) {
				addToCartButton.get(0).click();
				System.out.println("The chosen product is: " + productName);
				} 
			}
	}
	
	public void checkNumberOfArticle(String expectedValue) {
		getNumberOfArticle = numberOfArticle.getText().trim(); 
		compareString(getNumberOfArticle, expectedValue);
	}

}
