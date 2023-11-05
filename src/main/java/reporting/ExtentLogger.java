package reporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

import utils.ScreenshotUtils;

public class ExtentLogger {
	
	ExtentManager extentManager = null;
	
	public ExtentLogger() {
		extentManager = new ExtentManager();
	}

	public void pass(String message) {
        extentManager.getExtentTest().pass(message);
    }

    public void pass(Markup message) {
        extentManager.getExtentTest().pass(message);
    }

    public void fail(String message) {
        extentManager.getExtentTest().fail(message);
    }

    public void fail(Markup message) {
        extentManager.getExtentTest().fail(message);
    }

    public void skip(String message) {
        extentManager.getExtentTest().skip(message);
    }

    public void skip(Markup message) {
        extentManager.getExtentTest().skip(message);
    }

    public void info(Markup message) {
        extentManager.getExtentTest().info(message);
    }

    public void info(String message) {
        extentManager.getExtentTest().info(message);
    }

    public void captureScreenshot() {
        extentManager.getExtentTest().info("Capturing Screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
    }


	
}
