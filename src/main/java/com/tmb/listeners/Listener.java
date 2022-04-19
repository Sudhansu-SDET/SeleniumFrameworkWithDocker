package com.tmb.listeners;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.closeReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
