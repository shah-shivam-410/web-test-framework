package reporting;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	private static final String REPORT_PATH = ".//extent-reports//";
	private ExtentReports report = null;
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public void initiateReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(REPORT_PATH + "AutomationReport.html");
		try {
			reporter.loadXMLConfig(".//src//main//resources//extent-spark-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	public void endReport() {
		report.flush();
	}
	
	public void initiateTest(String name) {
		test.set(report.createTest(name));
	}
	
	public void endTest(String name) {
//		test.remove();
	}
	
	public static void log(Status status, String message) {
		test.get().log(status, message);
	}
	
}
