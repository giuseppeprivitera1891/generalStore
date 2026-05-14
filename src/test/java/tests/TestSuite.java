package tests;

import org.testng.annotations.Test;

import pageObjects.InformationPage;
import pageObjects.ProductPage;
import testUtils.BaseTest;

public class TestSuite extends BaseTest {
	String country = "Argentina";
	String name = "Klaudia Mondelez";
	String gender = "Female";
	String expectedTitle = "Products";
	String[] myProducts = { "Converse All Star", "Air Jordan 4 Retro"};
	String expectedNumberOfArticle = "3";
	
	@Test
	public void runSuite() {
		InformationPage informationPage = new InformationPage(driver);
		informationPage.selectCountry(country);
		informationPage.setName(name);
		informationPage.setGender(gender);
		
		ProductPage productPage = informationPage.goToProductPage();
		productPage.checkProductTitle(expectedTitle);
		productPage.selectProduct(myProducts);
		productPage.checkNumberOfArticle(expectedNumberOfArticle);
		productPage.goToTheCartPage();
		
		
		// product page
		/*
		 * driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")
		 * ).click();
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "com.androidsample.generalstore:id/toolbar_title"))); String cartTitle =
		 * driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).
		 * getText().trim(); Assert.assertEquals(cartTitle, "Cart");
		 */
		
	}
}
		

		
	
		  
	
	
	
	

	


		
		
		

			



