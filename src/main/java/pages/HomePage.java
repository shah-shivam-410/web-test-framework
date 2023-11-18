package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import locators.HomePageLocators;
import reporting.ExtentLogger;

public class HomePage extends BasePage implements HomePageLocators {

	ExtentLogger extentLogger = new ExtentLogger();
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void navigateToLoginPage() {
		getElement(accountLink).click();
		getElement(loginLink).click();
		extentLogger.info("User navigated to login page");
	}
	
	public void verifyUserLoggedin() {
		getElement(accountLink).click();
		Assert.assertTrue(isElementPresent(myAccountLink));
		extentLogger.pass("User login varified");
	}
	
	
}
