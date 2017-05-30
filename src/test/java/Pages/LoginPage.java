package Pages;

import Utils.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by adminnt on 28.04.17.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "mailbox__login")
    private WebElement name_;

    @FindBy(id = "mailbox__password")
    private WebElement password_;

    @FindBy(id = "mailbox__auth__button")
    private WebElement authButton_;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*public AfterLoginPage login(String name, String password) {
        name_.sendKeys(name);
        password_.sendKeys(password);
        authButton_.submit();
        return new AfterLoginPage(driver);
    }*/

    public AfterLoginPage login(User user) {
        name_.sendKeys(user.username);
        password_.sendKeys(user.password);
        authButton_.submit();
        return new AfterLoginPage(driver);
    }
}
