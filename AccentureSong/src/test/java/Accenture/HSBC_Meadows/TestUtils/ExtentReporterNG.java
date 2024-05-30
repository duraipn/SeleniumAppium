package Accenture.HSBC_Meadows.TestUtils;

import Accenture.HSBC_Meadows.enums.ConfigJson;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.util.Arrays;
import java.util.List;

import static Accenture.HSBC_Meadows.utils.configloader.JsonParser.getConfig;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReporterObject()
	{

	//	ExtentReports , ExtentSparkReporter
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		List<ViewName> DEFAULT_ORDER = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST);
		reporter.viewConfigurer().viewOrder().as(DEFAULT_ORDER);
		reporter.config().setReportName("Mobile Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTimelineEnabled(true);
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prabhu Durai");
		extent.setSystemInfo("Project Name", "HSBC_Meadows");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Platform", getConfig(ConfigJson.PLATFORM).toUpperCase());
		extent.setSystemInfo("Device Name", getConfig(ConfigJson.ANDROID_DEVICE_NAME).toUpperCase());
		extent.setSystemInfo("Environment", "Demo");
		return extent;
	}


}
