package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 11.05.2017.
 */
public class ContactPage extends MailPage {

    @FindBy(xpath = "//div[@class='js-checkbox b-checkbox b-checkbox_transparent b-checkbox_false js-shortcut']/div[@class='b-checkbox__box']")
    private WebElement checkboxReceiverInAddressBook;

    @FindBy(xpath = "//div[@class='b-filelabel__item_title__text']")
    private WebElement textAccountReceiver;

    @FindBy(xpath = "//button[@data-id='popup_ok']")
    private WebElement buttonAddReceiver;


    public void selectAccountReceiverInReceiverForm() {
        textAccountReceiver.click();
    }

    public SendEmailPage addSelectedReceiverToEmail() {
        buttonAddReceiver.click();
        return new SendEmailPage();
    }

    public WebElement getTextAccountReceiver() {
        return textAccountReceiver;
    }
}
