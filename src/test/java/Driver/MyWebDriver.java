package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by Andrey on 31.05.2017.
 */
public class MyWebDriver implements WebDriver {

    private WebDriver driver;
    static MyWebDriver myWebDriver = null;

    private MyWebDriver() {
        this.driver = MyDriverFactory.getDriver();
    }

    public static MyWebDriver getDriver() {
        if (myWebDriver == null) {
            return new MyWebDriver();
        } else {
            return myWebDriver;
        }
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public WebElement getWebElementWithVisibilityOfWait (WebElement element, int timeout) {
        return new WebDriverWait(driver, timeout, 500).
                until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getWebElementWithToBeClickableWait (WebElement webElement, int timeOut) {
        return new WebDriverWait(driver, timeOut, 500)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
