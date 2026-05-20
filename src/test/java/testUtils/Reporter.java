package testUtils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporter {
	static ExtentReports extent;
	static ExtentSparkReporter reporter;
	static String path;
	static String tester = "Giuseppe Privitera";
	
	@BeforeTest
	public static ExtentReports getReporterObject() {
		path = System.getProperty("user.dir") + "\\reports\\index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("General Store report");
		reporter.config().setDocumentTitle("Test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", tester);
		return extent;
	}

}
