package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement ele = null;
		try {
			ele = driver.findElement(locator);
		} catch (Exception e) {
			LOGGER.error("Error finding element : {}", locator);
			e.printStackTrace();
		}
		return ele;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			LOGGER.error("Error finding element : {}", locator);
			e.printStackTrace();
		}

	}

	@Override
	public boolean isElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			LOGGER.error("Error finding element : {}", locator);
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
			LOGGER.error("Error executing js");
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
				LOGGER.error("Atttempt to click {} failed {} times", locator, i);
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
				LOGGER.error("Atttempt to fill {} failed {} times", locator, i);
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
	
	public void tempMethod() {
		Actions act = new Actions(driver);
		act.dragAndDrop(null, null);
	}

}
