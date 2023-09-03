package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import locators.LoginPageLocators;

public class LoginPage extends BasePage implements LoginPageLocators {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String emailid, String passwd) {
		getElement(email).sendKeys(emailid);
		getElement(password).sendKeys(passwd);
		getElement(loginbtn).click();
	}

	public boolean verifyErrorMessageDisplayed() {
		boolean flag = false;
		try {
			flag = getElement(errorMessage).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
