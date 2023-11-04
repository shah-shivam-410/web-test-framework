package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public abstract WebElement getElement(By locator);
	
	public abstract void clickElement(By locator);
	
	public abstract void fillElement(By locator, String value);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract boolean isElementPresent(By locator);
	
	public abstract String getElementAttribute(By locator, String attribute);
	
	public <T extends BasePage> T getInstance(Class<T> pageclass) {
		try {
			return pageclass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
