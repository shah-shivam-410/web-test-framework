package utils;

import java.sql.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
//		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		return "base64";
	}

}
