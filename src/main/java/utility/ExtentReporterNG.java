
package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentReports extent = new ExtentReports();	
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("UI Automation Report");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("UI Automation Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Akash", "QA Team");
		return extent;
		
	}

}
