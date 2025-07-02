package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;
import io.qameta.allure.Step;
import locators.LoginPageLocators;
import reporting.ExtentLogger;

public class LoginPage extends BasePage implements LoginPageLocators {

	ExtentLogger extentLogger = new ExtentLogger();

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Step
	public void login(String emailid, String passwd) {
		fillElement(email, emailid);
		fillElement(password, passwd);
		clickElement(loginbtn);
		extentLogger.info("User clicked on login button");
	}
	
	@Step
	public void verifyErrorMessageDisplayed() {
		Assert.assertTrue(isElementPresent(errorMessage));
		extentLogger.captureScreenshot();
		extentLogger.pass("Error message displayed");
	}

}
