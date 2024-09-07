package temp;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Temp {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://www.google.com");
            driver.manage().addCookie(new Cookie("foo", "bar"));

            // Get cookie details with named cookie 'foo'
            Set<Cookie> cookie1 = driver.manage().getCookies();
            for(Cookie c : cookie1) {
            		System.out.println(c);
            }
        } finally {
            driver.quit();
        }
		
	}
	
	
	public void speak(int n1) {}
	public void speak(int n1, String... s1) {}
	
	
}
