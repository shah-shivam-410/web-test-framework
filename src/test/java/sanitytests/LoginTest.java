package sanitytests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import annoatations.Authors;
import base.BaseTest;
import driver.WebDriverSession;
import listeneres.IAnnotationTransformerImpl;
import listeneres.ITestListenerImpl;
import pages.HomePage;
import pages.LoginPage;
import reporting.ExtentLogger;

@Listeners({ ITestListenerImpl.class, IAnnotationTransformerImpl.class })
public class LoginTest extends BaseTest {
	ExtentLogger extentLogger = new ExtentLogger();
	private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);
	
	
	@Authors(authors = { "Shivam" })
	@Test(description = "Successful login", groups = { "Sanity" })
	void SuccessFul_Login() throws InterruptedException {
		HomePage homePage = new HomePage(WebDriverSession.getWebDriverSession());
		LoginPage loginPage = new LoginPage(WebDriverSession.getWebDriverSession());
		
		LOGGER.info("Test case started");
		Assert.assertEquals(homePage.getPageTitle(), "Your Store");
		homePage.navigateToLoginPage();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		loginPage.login("abc123@dda.qw", "abcabc");
		homePage.verifyUserLoggedin();
		Assert.assertEquals(loginPage.getPageTitle(), "My Account");
		LOGGER.info("Test case complete");
		
	}

	@Authors(authors = { "Shivam" })
	@Test(description = "UnSuccessful login", groups = { "Sanity" })
	void UnSuccessFul_Login() throws InterruptedException {
		HomePage homePage = new HomePage(WebDriverSession.getWebDriverSession());
		LoginPage loginPage = new LoginPage(WebDriverSession.getWebDriverSession());
		
		LOGGER.info("Test case started");
		Assert.assertEquals(homePage.getPageTitle(), "Your Store");
		homePage.navigateToLoginPage();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		loginPage.login("dasda", "asda");
		loginPage.verifyErrorMessageDisplayed();
		Assert.assertEquals(loginPage.getPageTitle(), "Account Login");
		LOGGER.info("Test case complete");
		
	}

	
}
