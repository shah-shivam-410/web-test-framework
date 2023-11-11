package driver;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Props;
import utils.ConfigReader;

public class WebDriverSession {

	protected static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	protected static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();

	protected static HashMap<Long, WebDriver> map = new HashMap<>();

	public static WebDriver getWebDriverSession() {
		return map.get(Thread.currentThread().getId());
	}
	
	public static void endWebDriverSession() {
		map.get(Thread.currentThread().getId()).quit();;
	}

	public static void startNewWebDriverSession() throws IOException {
		String browserType = ConfigReader.getProperty(Props.BROWSER).toLowerCase();
		System.out.println("Browser selected: " + browserType + " Thread id:" + Thread.currentThread().getId());
		try {
			WebDriver driver = null;
			switch (browserType) {
			case "chrome":
				System.getenv();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--ignore-ssl-errors=yes");
				chromeOptions.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(chromeOptions);
				webDriver.set(driver);
				break;

			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--ignore-ssl-errors=yes");
				firefoxOptions.addArguments("--ignore-certificate-errors");
				driver = new FirefoxDriver(firefoxOptions);
				webDriver.set(driver);
				break;

			default:
				throw new UnsupportedOperationException("Browser type not supported");

			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(ConfigReader.getProperty(Props.IMPLICIT_WAIT))));
			driver.manage().window().maximize();
			map.put(Thread.currentThread().getId(), (WebDriver) webDriver.get());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
