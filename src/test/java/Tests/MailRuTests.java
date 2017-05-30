package Tests;

import Pages.*;
import Utils.EmailFactory;
import Utils.UserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by adminnt on 28.04.17.
 */
public class MailRuTests extends BaseTest {

    LoginPage loginPage;
    AfterLoginPage afterLoginPage;
    SendEmailPage sendEmailPage;
    ContactPage contactPage;
    ConfirmSendEmptyEmailContentPage confirmSendEmptyEmailContentPage;
    ConfirmSendPage confirmSendPage;
    UserFactory userFactory;
    EmailFactory emailFactory;

    @BeforeClass
    public void beforeStartPositiveMailRuTests() {
        System.out.println("BeforeClass");
        loginPage = new LoginPage(driver);
        userFactory = new UserFactory();
        emailFactory = new EmailFactory();
    }

    @AfterClass
    public void afterFinishPositiveMailRuTests() {
        System.out.println("AfterClass");
        afterLoginPage.deleteRemainedTestEmailsWithSubject(emailFactory.getEmail().subject);
    }



    @Test(description = "LoginTest")
    public void loginTest() {
//        driver.manage().deleteAllCookies();
//        afterLoginPage = loginPage.login("mytest_test", "337774a");
        afterLoginPage = loginPage.login(userFactory.getValidUser());
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(afterLoginPage.getUserLoginEmail()));
        String mailUser = afterLoginPage.getMailUser();
//        Assert.assertEquals(mailUser, "mytest_test@mail.ru", "Login is not successful");
        Assert.assertEquals(mailUser, userFactory.getValidUser().email, "Login is not successful");
    }

    @Test(description = "Is there 'old' email with test subject", dependsOnMethods = "loginTest" )
    public void existOldEmail() {
//        Assert.assertFalse(afterLoginPage.getEmailSubject().getText().contains("AKhudyakov's test email"),
        Assert.assertFalse(afterLoginPage.getEmailSubject().getText().contains(emailFactory.getEmail().subject),
                "There is another the same email with Subject: \"AKhudyakov's test email\"");
    }


    @Test(description = "IsOpenedWriteEmailForm", dependsOnMethods = "loginTest")
    public void testEmailForm() throws Exception {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sendEmailPage = afterLoginPage.clickToStartWriteEmail();
        String labelWhomEmail = this.sendEmailPage.getLabelWhomEmail().getText();
        String expectedLabelLinkWhom = "\u041A" + "\u043E" + "\u043C" + "\u0443"; //"Кому"
        Assert.assertEquals(labelWhomEmail, expectedLabelLinkWhom, "Write Email Form is not opened");
    }

    @Test(description = "TestReceiverOfEmailForm", dependsOnMethods = "testEmailForm")
    public void testReceiverForm() throws Exception {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        contactPage = sendEmailPage.getFormEmailContact();
        String textAccountReceiver = contactPage.getTextAccountReceiver().getText();
//        Assert.assertEquals(textAccountReceiver, "mytest_test", "Expected receiver \"mytest_test\" is not present");
        Assert.assertEquals(textAccountReceiver, emailFactory.getEmail().receiverName, "Expected receiver \"mytest_test\" is not present");
    }

    @Test(description = "IsReceiverAddedToEmailForm", dependsOnMethods = "testReceiverForm")
    public void testAddReceiverFromAddressBook() throws Exception {

        contactPage.selectAccountReceiverInReceiverForm();
        sendEmailPage = contactPage.addSelectedReceiverToEmail();
        String actualReceiverName = sendEmailPage.getLabelAlreadyAddedReceiverInWhom().getText();
        Assert.assertEquals(actualReceiverName, emailFactory.getEmail().receiverName, "Expected receiver \"mytest_test\" is not present in field \"Whom \"");
    }

    @Test(description = "IsOpenedConfirmFormWhenEmptyEmailSend", dependsOnMethods = "testAddReceiverFromAddressBook")
    public void testConfirmEmptyBodyEmailForm() throws Exception {
        confirmSendEmptyEmailContentPage = sendEmailPage.SendEmptyBodyEmail();
        WebElement buttonConfirmEmptyEmail = confirmSendEmptyEmailContentPage.getButtonConfirmEmptyEmail();
        Assert.assertEquals(buttonConfirmEmptyEmail.isDisplayed(), true);
    }

    @Test(description = "TestSendEmptyBodyEmail", dependsOnMethods = "testConfirmEmptyBodyEmailForm")
    public void testSendEmptyBodyEmail() {
        confirmSendPage = confirmSendEmptyEmailContentPage.confirmSendEmptyEmail();
        String partOfExpectedSuccessfulMessage = "\u0412" + "\u0430" + "\u0448" + "\u0435"; //Ваше
        Assert.assertEquals(confirmSendPage.getSuccessfulTextSendEmail().getText().substring(0, 4), partOfExpectedSuccessfulMessage);
    }

    @Test(description = "IsThereEmailInEmailList", dependsOnMethods ="testSendEmptyBodyEmail")
    public void testPresentSentEmail() {
        afterLoginPage.goToInbox();
        driver.navigate().refresh();
        String expectedSubject = afterLoginPage.getEmailSubject().getText();
        Assert.assertTrue(expectedSubject.contains(emailFactory.getEmail().subject),
                "There is no sent email with subject: \"AKhudyakov's test email\"");
        Assert.assertEquals(afterLoginPage.countEmailWithSubject(emailFactory.getEmail().subject),1);
    }
}
