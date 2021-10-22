package com.epam.framework.listeners;

import com.epam.framework.loggers.Log;
import com.epam.framework.utils.ScreenShotTaker;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;


public class TestListener  implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // As of now no implementation required
    }
    @Override
    public void onTestStart(ITestResult result) {
    // As of now no implementation required
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.logInfo(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.logInfo(result.getName());
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
        File file= ScreenShotTaker.takeScreenShot(driver,result.getName());
        Log.logScreenShotToReportPortal(file,result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    Log.logInfo(result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // As of now no implementation required
    }

    @Override
    public void onFinish(ITestContext context) {
        // As of now no implementation required
    }
}
