package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
	WebDriver driver;
	int maxAttempts = 5;
	int attempt = 0;

	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By readMoreElement = By.id("KByQx");
	By acceptAllElement = By.id("L2AGLb");
	By searchBar = By.className("gLFyf");
	By goToWebSite = By.cssSelector("a[href='https://www.geox.com/it-IT/']");
	
	public void findProduct(String search) {
		// it has up to five attempts to close the cookie pop-up 
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
		
		driver.findElement(searchBar).sendKeys(search);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);	
		driver.findElement(goToWebSite).click();
	}

}
