package com.tmb.tests;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.tmb.driver.DriverManager.getDriver;

public final class LoginpageTest extends BaseTest{

    private LoginpageTest(){} // private constructor to avoid extends/object creation

    @Test
    public void test1() throws Throwable {
        getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

}
