package locators;

import org.openqa.selenium.By;

public interface RegisterPageLocators {

	By headerText 			= By.xpath("//div[@id='content']/h1");
	By firstName 			= By.id("input-firstname");
	By lastName 				= By.id("input-lastname");
	By email 				= By.id("input-email");
	By phone 				= By.id("input-telephone");
	By passwd 				= By.id("input-password");
	By confirmPasswd 		= By.xpath("//input[@id='input-confirm' and @type='password']");
	By newsletterNo 			= By.xpath("//input[@name='newsletter' and @value='0']");
	By policyAgreement 		= By.xpath("//input[@name='agree']");
	By submit 				= By.xpath("//input[@type='submit'and @value='Continue']");
	
	
}
