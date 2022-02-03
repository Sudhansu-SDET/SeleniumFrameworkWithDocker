package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.init_Driver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
