package sanitytests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	ExtentLogger logger = new ExtentLogger();
	Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	
	@Authors(authors = { "abc", "qwe123" })
	@Test(groups = { "Sanity" })
	void Test1() throws InterruptedException {
		logger.info("Test1");
		logger.info("Waititng");
		log.info("Hello guys");
		WebDriverSession.getWebDriverSession().get("http://127.0.0.1:8080/");
		System.out.println(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Authors(authors = { "abc", "okr993" })
//	@RetryFailedCount(value = 2)
	@Test(groups = { "Sanity", "Regression", "DVT" })
	void Test2() throws InterruptedException {
		logger.info("Test2");
		WebDriverSession.getWebDriverSession().get("https://jquery.com/");
		System.out.println(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Test
	void Test3() throws InterruptedException {
		logger.info("Test3");
		logger.captureScreenshot();
		logger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://www.selenium.dev/");
		System.out.println(WebDriverSession.getWebDriverSession().getTitle());
	}
	
//	@RetryFailedCount(value = 2)
	@Test
	void Test4() throws InterruptedException {
		logger.info("Test4");
		logger.captureScreenshot();
		logger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://Amazon.in");
		System.out.println(WebDriverSession.getWebDriverSession().getTitle());
	}

	@Test
	void Test5() throws InterruptedException {
		logger.info("Test5");
		logger.captureScreenshot();
		logger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		WebDriverSession.getWebDriverSession().get("https://facebook.com");
		System.out.println(WebDriverSession.getWebDriverSession().getTitle());
	}

	

	

	
}
