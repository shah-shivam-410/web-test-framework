package imagetest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

public class ImageComparisonTest {

	static WebDriver driver;
	static WebDriverWait wait;

	static By signInBtn = By.xpath("//button[@id='btn']");

	public static void main(String[] args) throws InterruptedException, IOException {

//		driver = new FirefoxDriver();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		driver.get("http://127.0.0.1:5500/index.html");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("E:\\Projects\\java-projects\\web-test-framework\\actual-img.png");
//		FileUtils.copyFile(src, dest);
//		
//		driver.quit();
		
		
		
//		BufferedImage expectedImg = ImageComparisonUtil.readImageFromResources("E:\\Projects\\java-projects\\web-test-framework\\src-img.png");
//		BufferedImage actualImg = ImageComparisonUtil.readImageFromResources("E:\\Projects\\java-projects\\web-test-framework\\actual-img.png");
//		
//		File comPareResult = new File("E:\\Projects\\java-projects\\web-test-framework\\compare-output-img.png");
//		
//		ImageComparisonResult result = new ImageComparison(expectedImg, actualImg).compareImages();
//		ImageComparisonUtil.saveImage(comPareResult, result.getResult());
		
		
		

	}

}
