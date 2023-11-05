package listeneres;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reporting.ExtentLogger;
import reporting.ExtentManager;
import reporting.ExtentReport;

public class ITestListenerImpl implements ITestListener {
	
	public ExtentReport extentReport = null;
	public ExtentManager extentManager = null;
	public ExtentLogger logger = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.pass("123pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.skip(MarkupHelper.createLabel("skip2344", ExtentColor.PURPLE));
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport = new ExtentReport();
		extentReport = new ExtentReport();
		logger = new ExtentLogger();
		extentReport.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flushReports();
	}

	
	
}
