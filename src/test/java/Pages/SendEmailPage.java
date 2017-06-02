package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 11.05.2017.
 */
public class SendEmailPage extends MailPage {

    @FindBy(xpath = "//div[@class='compose-head__row-wrapper compose-head__row-wrapper_to js-row']//label [@class='compose-label js-addressbook-link']/span [@class='compose-label__text']")
    private WebElement labelWhomEmail;

    @FindBy(xpath = "//label[@class='compose-label js-addressbook-link']")
    private WebElement linkWhomEmail;

    @FindBy(xpath = ".//textarea[@class='js-input compose__labels__input']")
    private WebElement textWhomEmailField;

    @FindBy(xpath = ".//input[@name='Subject']")
    private WebElement textSubjectField;

    @FindBy(xpath = "//body[@class='mceContentBody increase-font compose2']")
    private WebElement textEmailContent;

    @FindBy(xpath = "//div[@class='label-input']/div/span[3]/span[@class='compose__labels__label__text js-label-text']")
    private WebElement labelAlreadyAddedReceiverInWhom;

    @FindBy(xpath = "//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']/span[@class='b-toolbar__btn__text']")
    private WebElement buttonSendEmail;

    public ContactPage getFormEmailContact() {
        linkWhomEmail.click();
        return new ContactPage();
    }

    public ConfirmSendEmptyEmailContentPage sendEmptyBodyEmail(String subject) {
        textSubjectField.sendKeys(subject);
        buttonSendEmail.click();
        return new ConfirmSendEmptyEmailContentPage();
    }

    public WebElement getLabelWhomEmail() {return labelWhomEmail; }

    public WebElement getLabelAlreadyAddedReceiverInWhom() {
        return labelAlreadyAddedReceiverInWhom;
    }
}
