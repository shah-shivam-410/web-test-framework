package utils;

import java.sql.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.WebDriverSession;

public class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) WebDriverSession.getWebDriverSession()).getScreenshotAs(OutputType.BASE64);
	}

}
