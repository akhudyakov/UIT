package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 12.05.2017.
 */
public class ConfirmSendEmptyEmailContentPage extends MailPage {

    @FindBy(xpath = "//div [@class='is-compose-empty_in']//button[@class='btn btn_stylish btn_main confirm-ok']")
    private WebElement buttonConfirmEmptyEmail;


    public ConfirmationAboutSuccessfulSendEmailPage confirmSendEmptyEmail() {
        buttonConfirmEmptyEmail.click();
        return new ConfirmationAboutSuccessfulSendEmailPage();
    }

    public WebElement getButtonConfirmEmptyEmail() {        return buttonConfirmEmptyEmail;    }
}
