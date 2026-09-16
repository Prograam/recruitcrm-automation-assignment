package com.recruitcrm.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Recruit CRM Automation Report");
            spark.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Rohan Sahu");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
        }

        return extent;
    }

    public static void createTest(String name) {
        test.set(getInstance().createTest(name));
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flush() {
        getInstance().flush();
    }
}