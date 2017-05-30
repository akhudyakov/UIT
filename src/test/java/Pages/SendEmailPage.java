package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 11.05.2017.
 */
public class SendEmailPage extends AfterLoginPage {

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

    public SendEmailPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage getFormEmailContact() {
        linkWhomEmail.click();
        return new ContactPage(driver);
    }

    public ConfirmSendEmptyEmailContentPage SendEmptyBodyEmail() {
        textSubjectField.sendKeys("AKhudyakov's test email");
        buttonSendEmail.click();
        return new ConfirmSendEmptyEmailContentPage(driver);
    }

    public WebElement getLabelWhomEmail() {return labelWhomEmail; }

    public WebElement getTextSubjectField() {
        return textSubjectField;
    }

    public WebElement getLabelAlreadyAddedReceiverInWhom() {
        return labelAlreadyAddedReceiverInWhom;
    }

    public WebElement getButtonSendEmail() {   return buttonSendEmail; }
}
