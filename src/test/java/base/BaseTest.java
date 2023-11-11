package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver.WebDriverSession;

public class BaseTest {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public Page page;
	
	@BeforeSuite
	public void setUpRun() {
		
	}
	
	@AfterSuite
	public void tearDownRun() {

	}
	
	@BeforeMethod
	public void setup(ITestResult test) throws IOException {
		WebDriverSession.startNewWebDriverSession();
	}
	
	@AfterMethod
	public void teardown() {
		WebDriverSession.endWebDriverSession();
	}
}
