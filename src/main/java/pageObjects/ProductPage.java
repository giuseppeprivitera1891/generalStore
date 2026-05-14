package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	By visibleProductList = By.id("com.androidsample.generalstore:id/productName");
	
	int countProduct;
	String productName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/counterText")
	private WebElement numberOfArticle;
	
	String getNumberOfArticle; 
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	public void checkProductTitle(String expectedValue) {
		waitForElementToAppear(10, productTitle, "text", "Products");
		getProductTitle = productTitle.getText().trim();
		System.out.println("The title page is: " + getProductTitle);
		compareString(getProductTitle, expectedValue);
	}
	
	public void selectProduct(String[] chooseProducts) {
		countProduct = productList.size();
		for(String myProducts : chooseProducts) { 
			 for(int i = 0; i < countProduct; i++){
				 scrollToText(myProducts);
				 productName = productList.get(i).getText().trim();
				 if(productName.equalsIgnoreCase(myProducts)) {
					 waitForTextToAppear(1, visibleProductList);
					 System.out.println("The chosen product is: " + productName);
					 addToCartButton.get(i).click();
				 } 
			 }			
		}
	}
	
	public void checkNumberOfArticle(String expectedValue) {
		getNumberOfArticle = numberOfArticle.getText().trim(); 
		compareString(getNumberOfArticle, expectedValue);
	}

	public void goToTheCartPage() {
		cartButton.click();
	}
}
