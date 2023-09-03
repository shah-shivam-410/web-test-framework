package sanitytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	@Test(description = "Emailid is blank")
	public void veryfyFailureLogin1() throws InterruptedException {
		HomePage homePage = page.getInstance(HomePage.class);
		LoginPage loginPage = page.getInstance(LoginPage.class);
		
		homePage.navigateToLoginPage();
		loginPage.login("", "abcabc");
		Assert.assertTrue(loginPage.verifyErrorMessageDisplayed());
	}
	
	@Test(description = "Password is blank")
	public void veryfyFailureLogin2() throws InterruptedException {
		HomePage homePage = page.getInstance(HomePage.class);
		LoginPage loginPage = page.getInstance(LoginPage.class);
		
		homePage.navigateToLoginPage();
		loginPage.login("abc@abc.com", "");
		Assert.assertTrue(loginPage.verifyErrorMessageDisplayed());
	}
	
	@Test(description = "Incorrect credential")
	public void veryfyFailureLogin3() throws InterruptedException {
		HomePage homePage = page.getInstance(HomePage.class);
		LoginPage loginPage = page.getInstance(LoginPage.class);
		
		homePage.navigateToLoginPage();
		loginPage.login("abc@abc.com", "abcabc");
		Assert.assertTrue(loginPage.verifyErrorMessageDisplayed());
	}

}
