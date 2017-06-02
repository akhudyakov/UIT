package Pages;

import Driver.MyWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by adminnt on 28.04.17.
 */
public abstract class BasePage {

    static protected MyWebDriver driver = MyWebDriver.getDriver();
    static protected final String BASE_URL = "https://mail.ru/";

    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
