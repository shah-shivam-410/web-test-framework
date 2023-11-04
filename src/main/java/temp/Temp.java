package temp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Temp {

	public static void main(String[] args) throws IOException {
		String filepath = "E:\\Projects\\java-projects\\web-test-framework\\test-output\\ext";
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(filepath));
		report.attachReporter(reporter);
		
		ExtentTest pass = report.createTest("abc");
		pass.pass("TC passed");
		pass.log(Status.INFO, "<b>info1</b>");
		pass.log(Status.INFO, "<i>infoa2</i>");
		pass.log(Status.FAIL, "<b><i>fail1a1</i></b>");
		pass.log(Status.SKIP, "skip1");
		pass.log(Status.WARNING, "warning1");
		pass.log(Status.INFO, MarkupHelper.createLabel("info3", ExtentColor.BLUE));
		pass.log(Status.WARNING, "warning1");
		pass.log(Status.WARNING, "warning2");
		pass.log(Status.FAIL, "fail1");
		pass.log(Status.SKIP, "skip1");
		pass.log(Status.FAIL, "fail2");
		pass.log(Status.FAIL, "fail2");
		pass.log(Status.PASS, "fail2");
		
//		try {
//			int i = 10/0;
//		} catch (Exception e) {
//			pass.log(Status.FAIL	, e);
//		}

		System.out.println("Hello");
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<note>\r\n"
				+ "  <to>Tove</to>\r\n"
				+ "  <from>Jani</from>\r\n"
				+ "  <heading>Reminder</heading>\r\n"
				+ "  <body>C:\\Users\\SHIVAM SHAH\\Desktop\\img.txt forget me this weekend!</body>\r\n"
				+ "</note> ";
		
		ExtentTest fail = report.createTest("pqr");
		fail.log(Status.INFO, MarkupHelper.createCodeBlock(xml, CodeLanguage.XML));
		fail.fail("TC failed");
		
		String img = FileUtils.readFileToString(new File("C:\\Users\\SHIVAM SHAH\\Desktop\\img.txt"), StandardCharsets.UTF_8);
		fail.addScreenCaptureFromBase64String(img, "ss");
		fail.info(MediaEntityBuilder.createScreenCaptureFromBase64String(img, "inline").build());
		
		
		ExtentTest skip = report.createTest("xyz");
		skip.skip("TC skipped");
		
		report.flush();

	}
	
}
