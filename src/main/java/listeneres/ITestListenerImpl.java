package listeneres;

import static reporting.ReportManager.log;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import reporting.ReportManager;

public class ITestListenerImpl implements ITestListener {
	
	ReportManager reportManager = new ReportManager();

	@Override
	public void onTestStart(ITestResult result) {
		reportManager.initiateTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log(Status.PASS, "123");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log(Status.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log(Status.SKIP, "qpe");
	}

	@Override
	public void onStart(ITestContext context) {
		reportManager.initiateReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		reportManager.endReport();
	}

	
	
}
