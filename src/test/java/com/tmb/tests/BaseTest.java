package com.tmb.tests;

import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.tmb.utils.PropertyUtils.getFromPropFile;

public class BaseTest {

    @BeforeMethod
    protected void setUp() throws Exception {
       // Driver.init_Driver(getFromPropFile("browser"));
        Driver.init_Driver(getFromPropFile("browser"));
    }

    @AfterMethod
    protected void tearDown(){

        Driver.quitDriver();
    }
}
