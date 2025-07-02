package usecases;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Carousel {

	public static void main(String[] args) throws InterruptedException {

//		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.calculator.net/age-calculator.html");
//		Thread.sleep(3000);
//		printCarouselItems("4-October-1998", driver);
//		
//		Thread.sleep(5000);
//		driver.quit();

//		List<List<String>> departmentEmployees = Arrays.asList(Arrays.asList("John Doe", "Jane Smi Eh"),
//				Arrays.asList("Emily Davis", "Michael Brown"), Arrays.asList("Chris Wilson", "Sarah Johnson"));
//		System.out.println(departmentEmployees);
//		List<String> list = departmentEmployees.stream().flatMap(a -> a.stream()).filter(a -> a.startsWith("J") || a.startsWith("j")).collect(Collectors.toList());
//		System.out.println(list);
		
		List<Integer> list = List.of(4, 5, 19, 2100, 10, -5);
		Integer op = list.stream().reduce(0, (a,b) -> a+b);
		System.out.println(op);
		
	}

	public static void printCarouselItems(String sectionName, WebDriver driver) throws InterruptedException {

//		WebElement section = driver.findElement(By.xpath("//*[text()='" + sectionName + "']/ancestor::div[contains(@class, 'product-shoveler')]"));
//		List<WebElement> productList = section.findElements(By.xpath(".//ul/li/span/a/img"));
//		List<String> names = new ArrayList<>();
//		for(WebElement e : productList) {
//			names.add(e.getAttribute("alt"));
//		}
//		names.forEach(System.out::println);
//		
//		WebElement next = section.findElement(By.xpath("//a[@aria-label='Carousel next slide']"));
//		
//		while(!next.getDomAttribute("class").contains("feed-control-disabled")) {
//			next.click();
//			Thread.sleep(500);
//			System.out.println("*");
//		}

//		String tooltipXpath = "//*[local-name()='g' and contains(@class,'highcharts-tooltip')]//*[local-name()='text']";
//		String columnXpath = "//*[local-name()='g' and contains(@class,'highcharts-column')]//*[local-name()='rect' and contains(@class,'highcharts-point')]";
//		
//		List<WebElement> list = driver.findElements(By.xpath(columnXpath));
//		JavascriptExecutor jsx = (JavascriptExecutor) driver;
//		list.get(0).click();
//		jsx.executeScript("arguments[0].scrollIntoView(1);", list.get(0));
//		Actions act = new Actions(driver);
//		
//		for(var i : list) {
//			act.moveToElement(i).perform();
//			System.out.println(driver.findElement(By.xpath(tooltipXpath)).getText());
//		}

//		WebElement sliderHead = driver.findElement(By.xpath("//div[@id='loanamountslider']/span"));
//		for(int i=0; i<30; i++) {
//			sliderHead.sendKeys(Keys.ARROW_RIGHT);
//			System.out.println(sliderHead.getDomAttribute("style"));
//		}

//		String[] targateDate = sectionName.split("-");
//		driver.findElement(By.xpath("//td[text()='Date of Birth']/..//a[@id='today_ID_Link']")).click();
//		WebElement currentMonthYear = driver.findElement(By.xpath("//td[text()='Date of Birth']/..//td[@title='Show Current Month']"));
//		WebElement prevBtn = driver.findElement(By.xpath("//td[text()='Date of Birth']/..//td[@id='today_Previous_ID']"));
//		WebElement nextBtn = driver.findElement(By.xpath("//td[text()='Date of Birth']/..//td[@id='today_Next_ID']"));
//		while(currentMonthYear.getText().split("\\s")[1].equals(targateDate[2]) == false) {
//			prevBtn.click();
//		}
//		while(currentMonthYear.getText().split("\\s")[0].equals(targateDate[1]) == false) {
//			prevBtn.click();
//		}
//		driver.findElement(By.xpath("//td[text()='Date of Birth']/..//td[text()='" + targateDate[0] + "']")).click();

		String[] targateDate = sectionName.split("-");
		Select mSel = new Select(
				driver.findElement(By.xpath("//td[text()='Date of Birth']/..//select[@id='today_Month_ID']")));
		Select dSel = new Select(
				driver.findElement(By.xpath("//td[text()='Date of Birth']/..//select[@id='today_Day_ID']")));

		mSel.selectByVisibleText(targateDate[1].substring(0, 3));
		dSel.selectByVisibleText(targateDate[0]);

		WebElement yearField = driver
				.findElement(By.xpath("//td[text()='Date of Birth']/..//input[@id='today_Year_ID']"));
		yearField.sendKeys(Keys.CONTROL + "a");
		yearField.sendKeys(Keys.DELETE + targateDate[2]);

		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		String st = driver.findElement(By.xpath("//p[@class='verybigtext']")).getText();
		System.out.println(st);

	}

}
