package sanitytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import annoatations.RetryFailedCount;
import base.BaseTest;
import reporting.ExtentLogger;

public class LoginTest extends BaseTest {
	ExtentLogger logger = new ExtentLogger();
	
	@Test
	void Test1() {
		logger.info("Test1");
		Assert.assertEquals(5, 5);
	}
	
	@RetryFailedCount(value = 2)
	@Test
	void Test2() {
		logger.info("Test2");
		logger.skip("Test2 skip");
		Assert.assertEquals("abc1", "abc");
	}
	
	@RetryFailedCount(value = 4)
	@Test
	void Test3() {
		logger.info("Test3");
		logger.captureScreenshot();
		logger.info(MarkupHelper.createLabel("test label", ExtentColor.GREEN));
		Assert.assertEquals(true, false);
	}
	

}
