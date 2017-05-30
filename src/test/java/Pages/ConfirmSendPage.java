package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 24.05.2017.
 */
public class ConfirmSendPage extends AfterLoginPage {

    @FindBy(xpath = "//div[@class='message-sent__title']")
    private WebElement successfulTextSendEmail;

    public ConfirmSendPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSuccessfulTextSendEmail() {
        return successfulTextSendEmail;
    }
}
