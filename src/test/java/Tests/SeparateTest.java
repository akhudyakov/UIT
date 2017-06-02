package Tests;

import Driver.MyDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 08.05.2017.
 */
public class SeparateTest {

    WebDriver driver;
    final String URL = "http://output.jsbin.com/usidix/1";

    @BeforeClass
    public void setUp() throws Exception {
        driver = MyDriverFactory.getDriver();
        driver.get(URL);
    }

    @Test
    public void testButton() throws Exception {
        driver.findElement(By.xpath("html/body/input")).click();
    }
}
