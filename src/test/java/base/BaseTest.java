package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public Page page;
	
	@BeforeMethod
	public void setup() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		tldriver.set(driver);
		page = new BasePage(tldriver.get());
	}
	
	@AfterMethod
	public void teardown() {
		tldriver.get().quit();
	}
}
