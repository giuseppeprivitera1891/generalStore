package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FillInformationPage extends AndroidActions {
	public AndroidDriver driver;

	public FillInformationPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	By productTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
	
	public void selectCountry(String country) {
		countrySelection.click();
		scrollToText(country);
		WebElement chooseCountry = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+ country + "\")"));
		chooseCountry.click();
		System.out.println("The country selected is: " + chooseCountry.getText());
	}
	
	public void setName(String name) {
		nameField.sendKeys(name);
		System.out.println("The name setted is: " + nameField.getText());
	}
	
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			maleOption.click();
			System.out.println("The gender selected is: " + maleOption.getText());
		} else {
			femaleOption.click();
			System.out.println("The gender selected is: " + femaleOption.getText());
		}
	}
	
	public void goToProductPage() {
		shopButton.click();
		waitForElementToAppear(5, productTitle);
	}

}
