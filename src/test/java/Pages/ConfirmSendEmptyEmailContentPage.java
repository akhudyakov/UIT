package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrey on 12.05.2017.
 */
public class ConfirmSendEmptyEmailContentPage extends AfterLoginPage {

    @FindBy(xpath = "//div [@class='is-compose-empty_in']//button[@class='btn btn_stylish btn_main confirm-ok']")
    private WebElement buttonConfirmEmptyEmail;


    public ConfirmSendEmptyEmailContentPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmSendPage confirmSendEmptyEmail() {
        buttonConfirmEmptyEmail.click();
        return new ConfirmSendPage(driver);
    }

    public WebElement getButtonConfirmEmptyEmail() {
        return buttonConfirmEmptyEmail;
    }
}
