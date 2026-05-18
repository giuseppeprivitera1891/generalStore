package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebViewPage {
	WebDriver driver;
	int maxAttempts = 5;
	int attempt = 0;

	public WebViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By readMoreElement = By.id("KByQx");
	By acceptAllElement = By.id("L2AGLb");
	
	public void searchProduct() {
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
		
		driver.findElement(By.className("gLFyf")).sendKeys("GEOX");
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
		
	}

}
