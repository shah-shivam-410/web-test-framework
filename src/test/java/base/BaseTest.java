package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import reporting.ExtentLogger;
import reporting.ExtentManager;
import reporting.ExtentReport;

public class BaseTest {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public Page page;
	
	public ExtentReport extentReport = null;
	public ExtentManager extentManager = null;
	public ExtentLogger logger = null;
	
	@BeforeSuite
	public void setUpRun() {
		
	}
	
	@AfterSuite
	public void tearDownRun() {

	}
	
	@BeforeMethod
	public void setup(ITestResult test) {

	}
	
	@AfterMethod
	public void teardown() {

	}
}
