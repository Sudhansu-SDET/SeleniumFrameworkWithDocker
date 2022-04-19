package com.tmb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.utils.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentLogger {
    private void ExtentLogger(){ /* private constructor */ }

    public static void pass(String amessage){

        ExtentManager.getExtentTest().pass(amessage);
    }
    public static void fail(String amessage){

        ExtentManager.getExtentTest().fail(amessage);
    }
    public static void skip(String amessage){

        ExtentManager.getExtentTest().skip(amessage);
    }

    public static void pass(String amessage, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.getFromPropFile("passedstepscreenshot").equalsIgnoreCase("yes")
        && isScreenShotNeeded){
        ExtentManager.getExtentTest().pass(amessage, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    public static void fail(String amessage, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.getFromPropFile("failedstepscreenshot").equalsIgnoreCase("yes")
                && isScreenShotNeeded){
            ExtentManager.getExtentTest().pass(amessage, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }
    public static String getBase64Image(){
       return  ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
