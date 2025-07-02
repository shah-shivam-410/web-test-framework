package temp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Temp {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		List<String> list = driver.findElements(By.tagName("a")).stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());
		System.out.println("Total links: " + list.size());
		list.stream().forEach(e -> {
			if(e != null) verifyLink(e);
		});
		
		driver.quit();

	}

	private static void verifyLink(String i) {
		try {
			
			URL url = new URL(i);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.connect();
			if (conn.getResponseCode() != 200) {
				System.out.println("Broken link: " + i);
			}
			conn.disconnect();
			conn = null;
		} 
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			System.out.println("Finally");
		}
	}

}
