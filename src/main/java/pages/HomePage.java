package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import locators.HomePageLocators;

public class HomePage extends BasePage implements HomePageLocators {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void navigateToLoginPage() {
		getElement(accountLink).click();
		getElement(loginLink).click();
	}
	
}
