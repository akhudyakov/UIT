package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by adminnt on 29.04.17.
 */
public class MailPage extends BasePage {

    @FindBy(id = "PH_user-email")
    private WebElement userLoginEmail;

    @FindBy(xpath = "//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElement writeMailButton;

    ////div[text()="AKhudyakov's test email"]
    @FindBy(xpath = "//div[1][@class='b-datalist__item__subj']")
    private WebElement emailSubject;

    @FindBy(xpath = "//div[@data-name='remove']")
    private WebElement buttonDeleteEmail;

    @FindBys(@FindBy(xpath = "//div[@class='b-datalist__item__subj']"))
    private List<WebElement> listEmailsubjects;

    @FindBy(xpath = "//i[@class='ico ico_folder ico ico_folder_inbox']")
    private WebElement linkInbox;

    public void goToInbox() {
        linkInbox.click();
    }

    public SendEmailPage clickToStartWriteEmail() {
        writeMailButton.click();
        return new SendEmailPage();
    }

    protected void deleteRemainedTestEmailsWithSubject(String subject) {
        int countTotalEmails = 0;
        List<WebElement> emailSubjects = getEmailSubjects();
        for (WebElement element : emailSubjects) {
            countTotalEmails++;
            if (element.getText().contains(subject)) {
                //counting happens from basis point that is subject of the top email
//              Webelement checkbox = driver.findElement(By.xpath(".//../../../../div[@class='js-item-checkbox b-datalist__item__cbx']")); //work only for the top email
                WebElement checkbox = driver.findElement(By.xpath(".//../../../../../../../div[" + countTotalEmails + "]/div/a//div[@class='js-item-checkbox b-datalist__item__cbx']"));
                checkbox.click();
            }
        }
        buttonDeleteEmail.click();
    }

    protected int countEmailsWithSubject(String subject) {
        int countEmailsWithsubject = 0;
        List<WebElement> emailSubjects = getEmailSubjects();
        for (WebElement element : emailSubjects) {
            if (element.getText().contains(subject)) {
                countEmailsWithsubject++;
            }
        }
        return countEmailsWithsubject;
    }

    public WebElement getUserLoginEmail() {
        return driver.getWebElementWithVisibilityOfWait(userLoginEmail, 5);
    }

    public WebElement getEmailSubject() {
        return emailSubject;
    }

    public List<WebElement> getEmailSubjects() {
        return listEmailsubjects;
    }

    public void refresh() {
        driver.navigate().refresh();
    }


}
