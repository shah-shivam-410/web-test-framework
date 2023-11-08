package utils;

public class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
//		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		return "base64";
	}

}
