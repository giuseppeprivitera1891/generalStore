package testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	ExtentReports extent;
	ExtentSparkReporter reporter;
	String path;
	String tester = "Giuseppe Privitera";
	
	public ExtentReports getReporterObject() {
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
