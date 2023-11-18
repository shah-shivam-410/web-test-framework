package locators;

import org.openqa.selenium.By;

public interface HomePageLocators {

	By accountLink 		= By.cssSelector("a[title='My Account']");
	By loginLink 		= By.linkText("Login");
	By registerLink 		= By.linkText("Register");
	By myAccountLink 	= By.linkText("My Account");
	By logoutLink 		= By.linkText("Logout"); 

}
