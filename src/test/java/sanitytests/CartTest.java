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
import listeneres.IAnnotationTransformerImpl;
import listeneres.ITestListenerImpl;
import pages.HomePage;
import pages.LoginPage;
import reporting.ExtentLogger;

@Listeners({ ITestListenerImpl.class, IAnnotationTransformerImpl.class })
public class CartTest extends BaseTest {
	ExtentLogger extentLogger = new ExtentLogger();
	
	
	@Authors(authors = { "Shivam" })
	@Test(description = "Successful login", groups = { "Sanity" })
	void AddToCart_TV() throws InterruptedException, SQLException, IOException {
		
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

	@Authors(authors = { "Shivam" })
	@Test(description = "UnSuccessful login", groups = { "Sanity" })
	void UnSuccessFul_Login() throws InterruptedException, SQLException, IOException {
		
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
