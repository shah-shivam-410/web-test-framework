package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public Page page;
	
	@BeforeMethod
	public void setup() {
		
	}
	
	@AfterMethod
	public void teardown() {
		
	}
}
