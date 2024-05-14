package src.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/extent-report.html");
        reporter.config().setReportName("Execution_Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("hellolunajoy", "https://hellolunajoy.com/");
        return extentReports;
    }
}
