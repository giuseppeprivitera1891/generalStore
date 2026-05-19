package tests;

import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.SearchProductPage;
import testUtils.BaseTest;

public class TestSuite extends BaseTest {
	String country = "Argentina";
	String name = "Klaudia Mondelez";
	String gender = "Female";
	String expectedTitle = "Products";
	String[] myProducts = {"Converse All Star", "Air Jordan 4 Retro"};
	String expectedNumberOfArticle = "2";
	String expectedCartTitle = "Cart";
	String search = "Geox";
	SearchProductPage searchProduct;
	
	@Test
	public void runSuite() {
		informationPage.selectCountry(country);
		informationPage.setName(name);
		informationPage.setGender(gender);
		
		ProductPage productPage = informationPage.goToProductPage();
		productPage.checkProductTitle(expectedTitle);
		productPage.selectProduct(myProducts);
		productPage.checkNumberOfArticle(expectedNumberOfArticle);
		
		CartPage cartPage = productPage.goToTheCartPage();
		cartPage.checkCartTitle(expectedCartTitle);
		cartPage.checkTotalPrice();
		cartPage.checkTerms();
		cartPage.receiveEmail();
		cartPage.gotToWebSite();
		
		SearchProductPage searchProduct = new SearchProductPage(driver);
		searchProduct.findProduct(search);
			
	}
}
		

		
	
		  
	
	
	
	

	


		
		
		

			



