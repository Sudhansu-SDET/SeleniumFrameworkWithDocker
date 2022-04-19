package Archieve.Executables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static com.tmb.driver.DriverManager.getDriver;
import static com.tmb.driver.DriverManager.setDriver;
import static com.tmb.utils.PropertyUtils.getFromPropFile;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws Exception {

        WebDriver driver = null;
        String Runmode = getFromPropFile("runmode");

        if (Objects.isNull(getDriver(getFromPropFile("browser")))) {
            if (browser.equalsIgnoreCase("chrome")) {

                if (Runmode.equalsIgnoreCase("Remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("chrome");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap );
                } else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

                }
            }
             else if (browser.equalsIgnoreCase("edge")) {

                if (Runmode.equalsIgnoreCase("Remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("Edge");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                } else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }


        }
        return driver;
    }
}
