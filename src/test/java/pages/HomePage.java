package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import io.qameta.allure.Step;
import locators.HomePageLocators;
import reporting.ExtentLogger;

public class HomePage extends BasePage implements HomePageLocators {

	ExtentLogger extentLogger = new ExtentLogger();
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Step
	public void navigateToLoginPage() {
		getElement(accountLink).click();
		getElement(loginLink).click();
		extentLogger.info("User navigated to login page");
	}
	
	@Step
	public void logoutUser() {
		getElement(accountLink).click();
		getElement(logoutLink).click();
		extentLogger.info("User logged out");
	}
	
	@Step
	public void verifyUserLoggedin() {
		getElement(accountLink).click();
		Assert.assertTrue(isElementPresent(myAccountLink));
		extentLogger.captureScreenshot();
		extentLogger.pass("User login varified");
	}
	
	@Step
	public void clickAddToCartTv() {
		getElement(addToCartTV).click();
		Assert.assertEquals(getPageTitle(), "Apple Cinema 30");
	}
}
