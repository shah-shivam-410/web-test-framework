package locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {

	By email = By.id("input-email");
	By password = By.id("input-password");
	By loginbtn = By.cssSelector("input[value='Login']");
	
	By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
	
}
