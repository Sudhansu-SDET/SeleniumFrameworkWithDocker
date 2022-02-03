package com.tmb.driver;

import com.tmb.utils.ReadPropertyFile;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static com.tmb.constants.FrameworkConstants.getCHROMEDRIVERPATH;
import static com.tmb.driver.DriverManager.*;

public final class Driver {

    private Driver() {
    }

    public static void init_Driver() throws Exception {
        if (Objects.isNull(getDriver())) {
            System.setProperty("webdriver.chrome.driver", getCHROMEDRIVERPATH());
            setDriver(new ChromeDriver());
            getDriver().get(ReadPropertyFile.get("url"));
            getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
