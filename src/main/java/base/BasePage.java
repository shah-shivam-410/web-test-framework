package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement ele = null;
		try {
			ele = driver.findElement(locator);
		} catch (Exception e) {
			System.err.println("Error finding element : " + locator);
			e.printStackTrace();
		}
		return ele;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.err.println("Error finding element : " + locator);
			e.printStackTrace();
		}

	}

	@Override
	public boolean isElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			System.err.println("Error finding element : " + locator);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getElementAttribute(By locator, String attribute) {
		String val = null;
		try {
			val = (String) js.executeScript("return arguments[0]. getAttribute('" + attribute + "');", getElement(locator));
		} catch (Exception e) {
			System.err.println("Error executing js");
			e.printStackTrace();
		}
		return val;
	}

}
