package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends Page {
	
	Logger log = LoggerFactory.getLogger(BasePage.class);

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
			val = (String) js.executeScript("return arguments[0]. getAttribute('" + attribute + "');",
					getElement(locator));
		} catch (Exception e) {
			System.err.println("Error executing js");
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public void clickElement(By locator) {
		int i = 0;
		while (i < 2) {
			try {
				getElement(locator).click();
				break;
			} catch (Exception e) {
				log.error("Atttempt to click {} failed {} times", locator, i);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				i++;
			}
		}
	}

	@Override
	public void fillElement(By locator, String value) {
		int i = 0;
		while (i < 2) {
			try {
				getElement(locator).sendKeys(value);
				break;
			} catch (Exception e) {
				log.error("Atttempt to fill {} failed {} times", locator, i);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				i++;
			}
		}
	}

}
