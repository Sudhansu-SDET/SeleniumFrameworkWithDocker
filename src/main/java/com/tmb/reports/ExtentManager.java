package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {
    private void ExtentManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return extTest.get();
    }
    static void setExtentTest(ExtentTest test){
        extTest.set(test);
    }

    static void unload(){
        extTest.remove();
    }
//no modifier will be accesed wityhnthe package



}
