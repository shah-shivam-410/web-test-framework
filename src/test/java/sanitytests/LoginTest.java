package sanitytests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import annoatations.Authors;
import base.BaseTest;
import driver.WebDriverSession;
import listeneres.IAnnotationTransformerImpl;
import listeneres.ITestListenerImpl;
import reporting.ExtentLogger;

@Listeners({ ITestListenerImpl.class, IAnnotationTransformerImpl.class })
public class LoginTest extends BaseTest {
	ExtentLogger extentLogger = new ExtentLogger();
	private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);
	
	
	@Authors(authors = { "abc", "qwe123" })
	@Test(groups = { "Sanity" })
	void Test1() throws InterruptedException {
		extentLogger.info("Test1");
		extentLogger.info("Waititng");
		WebDriverSession.getWebDriverSession().get("http://127.0.0.1:8080/");
		LOGGER.info(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Authors(authors = { "abc", "okr993" })
//	@RetryFailedCount(value = 2)
	@Test(groups = { "Sanity", "Regression", "DVT" })
	void Test2() throws InterruptedException {
		extentLogger.info("Test2");
		WebDriverSession.getWebDriverSession().get("https://jquery.com/");
		LOGGER.info(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Test
	void Test3() throws InterruptedException {
		extentLogger.info("Test3");
		extentLogger.captureScreenshot();
		extentLogger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://www.selenium.dev/");
		LOGGER.info(WebDriverSession.getWebDriverSession().getTitle());
	}
	
//	@RetryFailedCount(value = 2)
	@Test
	void Test4() throws InterruptedException {
		extentLogger.info("Test4");
		extentLogger.captureScreenshot();
		extentLogger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://Amazon.in");
		LOGGER.info(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Test
	void Test5() throws InterruptedException {
		extentLogger.info("Test5");
		extentLogger.captureScreenshot();
		extentLogger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://facebook.com");
		LOGGER.info(WebDriverSession.getWebDriverSession().getTitle());
	}	

	
}
