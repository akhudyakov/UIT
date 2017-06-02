package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 24.05.2017.
 */
public class ConfirmationAboutSuccessfulSendEmailPage extends MailPage {

    @FindBy(xpath = "//div[@class='message-sent__title']")
    private WebElement successfulTextSendEmail;

    public WebElement getSuccessfulTextSendEmail() {
        return successfulTextSendEmail;
    }
}
