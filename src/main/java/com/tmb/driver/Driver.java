package com.tmb.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

import static com.tmb.driver.DriverManager.*;
import static com.tmb.utils.PropertyUtils.getFromPropFile;

//import static com.tmb.utils.ReadPropertyFile.get;

public final class Driver {

    private static String Runmode;

    private Driver() {
    }

    public static void init_Driver(String browser) throws Exception {

        String Runmode = getFromPropFile("runmode");

        if (Objects.isNull(getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {

                if (Runmode.equalsIgnoreCase("Remote")) {
                    System.out.println("Running test in docker");
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("chrome");
                    setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
                } else {
                    WebDriverManager.chromedriver().setup();
                    setDriver(new ChromeDriver());

                }
            } else if (browser.equalsIgnoreCase("edge")) {

                if (Runmode.equalsIgnoreCase("Remote")) {
                    System.out.println("Running test in docker");
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("Edge");
                    setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
                } else {
                    WebDriverManager.edgedriver().setup();
                    setDriver(new EdgeDriver());
                }
            }

            getDriver().get(getFromPropFile("url"));
            getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
