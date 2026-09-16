package com.recruitcrm.reports;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test Passed");
    }

    private String captureScreenshot(WebDriver driver, String testName) {

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String folder = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator;

        new File(folder).mkdirs();

        String path = folder + testName + "_" + time + ".png";

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver =
                (WebDriver) result.getTestContext().getAttribute("driver");

        String screenshotPath =
                captureScreenshot(driver, result.getName());

        ExtentManager.getTest()
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
    }
}