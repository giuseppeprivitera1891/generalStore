package org.giuseppeprivitera.tests;

import org.giuseppeprivitera.pageObjects.CartPage;
import org.giuseppeprivitera.pageObjects.ProductPage;
import org.giuseppeprivitera.pageObjects.SearchProductPage;
import org.giuseppeprivitera.testUtils.BaseTest;
import org.testng.annotations.Test;

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
		

		
	
		  
	
	
	
	

	


		
		
		

			



