package reporting;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManger {

	private static final String REPORT_PATH = ".//extent-reports//";
	private static ExtentSparkReporter reporter = null;
	private static ExtentReports report = null;
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static void initiateReport() {
		reporter = new ExtentSparkReporter(REPORT_PATH + new Date().toString().replaceAll("[\\s:]", "-") + ".html");
		report = new ExtentReports();
		report.attachReporter(reporter);	
	}
	
	public static void endReport() {
		report.flush();
	}
	
	public static void initiateTest(String name) {
		test.set(report.createTest(name));
	}
	
	public static void log(Status status, String message) {
		test.get().log(status, message);
	}
	
}
