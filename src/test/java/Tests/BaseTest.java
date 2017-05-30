package Tests;

import Factory.MyDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by adminnt on 28.04.17.
 */
public class BaseTest {

    protected WebDriver driver;
    final String BASE_URL = "https://mail.ru/";

    @BeforeSuite
    public void beforeSuit() {
        driver = MyDriverFactory.getDriver();
        driver.get(BASE_URL);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Aftersuite");
        driver.quit();
    }

}
