package locators;

import org.openqa.selenium.By;

public interface ProductPageLocators {

	By productNameHead 		= By.xpath("//div[@id='product-product']//h1");
	By loginLink 		= By.linkText("Login");
	By registerLink 		= By.linkText("Register");
	By myAccountLink 	= By.linkText("My Account");
	By logoutLink 		= By.linkText("Logout"); 
	By addToCartTV		= By.xpath("//*[text()='Apple Cinema 30\"']/../../../div//*[text()='Add to Cart']/..");


}