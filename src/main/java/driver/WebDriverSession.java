package driver;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.SystemProperties;

public class WebDriverSession {

	protected static volatile ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	protected static volatile ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();

	protected static HashMap<Long, WebDriver> map = new HashMap<>();

	public static WebDriver getWebDriverSession() {
		WebDriver toReturn = map.get(Thread.currentThread().getId());
		return toReturn;
	}

	public static void loadNewWebDriverSession() {
		String browserType = SystemProperties.BROWSER;
		try {
			switch (browserType) {
			case "CHROME":
				System.getenv();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("--incognito");
				chromeOptions.addArguments("--ignore-ssl-errors=yes");
				chromeOptions.addArguments("--ignore-certificate-errors");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				chromeOptions.merge(capabilities);

				if (SystemProperties.REMOTE) {
					System.out.println("Remote Grid to be used: " + SystemProperties.SELENIUM_GRID_URL);
					RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://10.78.196.236:4444/wd/hub"),
							chromeOptions);
					map.put(Thread.currentThread().getId(), (WebDriver) remoteWebDriver.getSessionId());

				} else {
					webDriver.set(new ChromeDriver(chromeOptions));
				}
				break;
			default:
				throw new UnsupportedOperationException("Browser type not supported");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (webDriver == null) {
			throw new UnsupportedOperationException("webDriver is null");
		} else {
			if (SystemProperties.REMOTE == false) {
				map.put(Thread.currentThread().getId(), (WebDriver) webDriver.get());
			}
		}

	}

	public static Browser getBrowser() {
		String browser = SystemProperties.BROWSER;
		switch (browser) {
		case "CHROME":
			return Browser.CHROME;
		case "FIREFOX":
			return Browser.FIREFOX;
		case "IE":
			return Browser.IE11;
		default:
			throw new UnsupportedOperationException(browser + " Browser is not supported.");
		}
	}

}
