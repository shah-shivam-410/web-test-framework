package sanitytests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import annoatations.Authors;
import base.BaseTest;
import database.DbOperations;
import driver.WebDriverSession;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeneres.IAnnotationTransformerImpl;
import listeneres.ITestListenerImpl;
import pages.HomePage;
import pages.LoginPage;
import reporting.ExtentLogger;

@Listeners({ ITestListenerImpl.class, IAnnotationTransformerImpl.class })
public class LoginTest extends BaseTest {
	ExtentLogger extentLogger = new ExtentLogger();
	
	@Owner("Shivam")
	@Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
	@Authors(authors = { "Shivam" })
	@Test(description = "Successful login", groups = { "Sanity" })
	void SuccessFul_Login() throws InterruptedException, SQLException, IOException {
		Allure.label("tag", "NewUI");
		Allure.label("tag", "Essentials");
		HomePage homePage = new HomePage(WebDriverSession.getWebDriverSession());
		LoginPage loginPage = new LoginPage(WebDriverSession.getWebDriverSession());
		DbOperations dbOperations = new DbOperations();
		
		Assert.assertEquals(homePage.getPageTitle(), "Your Store");
		homePage.navigateToLoginPage();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		String[] user = dbOperations.getValidUserCredential();
		loginPage.login(user[0], user[1]);
		homePage.verifyUserLoggedin();
		Assert.assertEquals(loginPage.getPageTitle(), "My Account");
		homePage.logoutUser();
		
	}

	@Owner("Sid")
	@Severity(SeverityLevel.CRITICAL)
	@Authors(authors = { "Shivam" })
	@Test(description = "UnSuccessful login", groups = { "Sanity" })
	void UnSuccessFul_Login() throws InterruptedException, SQLException, IOException {
		Allure.label("tag", "Essentials");
		
		HomePage homePage = new HomePage(WebDriverSession.getWebDriverSession());
		LoginPage loginPage = new LoginPage(WebDriverSession.getWebDriverSession());
		DbOperations dbOperations = new DbOperations();
		
		Assert.assertEquals(homePage.getPageTitle(), "Your Store");
		homePage.navigateToLoginPage();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		String[] user = {"adsda", "awerq"};
		loginPage.login(user[0], user[1]);
		loginPage.verifyErrorMessageDisplayed();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		
	}

	
}
