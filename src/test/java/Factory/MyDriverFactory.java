package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by adminnt on 28.04.17.
 */
public class MyDriverFactory {
    private static DesiredCapabilities capabilities;

    public static WebDriver getDriver() {
        WebDriver driver = null;
        String nameDriver = System.getProperty("driver");
        if (nameDriver != null) {
            switch (nameDriver) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
                    capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
                     driver = new ChromeDriver(capabilities);
                    break;
//                //                return new AppiumDriver<>() {}
                case "firefox":
//                    FirefoxBinary binary = new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox64\\firefox.exe "));
                    System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
//                    return new FirefoxDriver(binary);
                    driver =  new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", "Drivers\\MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
                    capabilities = DesiredCapabilities.internetExplorer();
//                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//                    capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//                    capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                    capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    driver = new InternetExplorerDriver(capabilities);
                    break;
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setBinary("C:\\Program Files (x86)\\Comodo\\Dragon\\dragon.exe");
                    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
                    capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    driver =  new ChromeDriver(capabilities);
                    break;
            }
        } else {
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}