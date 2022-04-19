package com.tmb.tests;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

import static com.tmb.driver.DriverManager.getDriver;

public final class LoginpageTest extends BaseTest{

    private LoginpageTest(){} // private constructor to avoid extends/object creation

    @Test(dataProvider="getData")
    public void DockerTest(String browser) throws Throwable {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https:www.google.com");
        System.out.println("Title is " + driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider(parallel=false)
    public Object[][] getData(){
        return new Object[][]{
                {"chrome"},{"chrome"},{"edge"},{"edge"}
        };
    }

}
