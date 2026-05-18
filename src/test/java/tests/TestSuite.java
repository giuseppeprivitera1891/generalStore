package tests;

import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.InformationPage;
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
	
	@Test
	public void runSuite() throws InterruptedException{
		InformationPage informationPage = new InformationPage(driver);
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
		
		SearchProductPage webViewPage = new SearchProductPage(driver);
		webViewPage.searchProduct(search);
			
	}
}
		

		
	
		  
	
	
	
	

	


		
		
		

			



