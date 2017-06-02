package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by adminnt on 28.04.17.
 */
public class MailRuTests extends BaseTest {


    @BeforeClass
    public void beforeStartPositiveMailRuTests() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterFinishPositiveMailRuTests() {
        System.out.println("AfterClass");
        app.mailMain.deleteEmailsWithSubject();
    }



    @Test(description = "LoginTest")
    public void loginTest() {
        app.login.loginValidUser();
        Assert.assertEquals(app.mailMain.getUserLoginEmail().getText(), validUser.email, "Login is not successful");
    }

    @Test(description = "Is there 'old' email with test subject", dependsOnMethods = "loginTest" )
    public void existOldEmail() {
        Assert.assertFalse(app.mailMain.getEmailSubject().getText().contains(emailSubject),
                "There is another the same email with Subject: \"AKhudyakov's test email\"");
    }


    @Test(description = "IsOpenedWriteEmailForm", dependsOnMethods = "loginTest")
    public void testEmailForm() throws Exception {
        app.mailMain.clickToStartWriteEmail();
        String labelWhomEmail = app.sendEmptyEmail.getLabelWhomEmail().getText();
        String expectedLabelLinkWhom = "\u041A" + "\u043E" + "\u043C" + "\u0443"; //"Кому"
        Assert.assertEquals(labelWhomEmail, expectedLabelLinkWhom, "Write Email Form is not opened");
    }

    @Test(description = "TestReceiverOfEmailForm", dependsOnMethods = "testEmailForm")
    public void testReceiverForm() throws Exception {
        app.sendEmptyEmail.getFormEmailContact();
        String textAccountReceiver = app.selectContact.getTextAccountReceiver().getText();
        Assert.assertEquals(textAccountReceiver, emailReceiver, "Expected receiver \"mytest_test\" is not present");
    }

    @Test(description = "IsReceiverAddedToEmailForm", dependsOnMethods = "testReceiverForm")
    public void testAddReceiverFromAddressBook() throws Exception {
        app.selectContact.selectAccountReceiverInReceiverForm();
        app.selectContact.addSelectedReceiverToEmail();
        String actualReceiverName = app.sendEmptyEmail.getLabelAlreadyAddedReceiverInWhom().getText();
        Assert.assertEquals(actualReceiverName, emailReceiver, "Expected receiver \"mytest_test\" is not present in field \"Whom \"");
    }

    @Test(description = "IsOpenedConfirmFormWhenEmptyEmailSend", dependsOnMethods = "testAddReceiverFromAddressBook")
    public void testConfirmEmptyBodyEmailForm() throws Exception {
        app.sendEmptyEmail.sendEmptyEmailWithSubject();
        WebElement buttonConfirmEmptyEmail = app.confirmSendEmptyEmail.getButtonConfirmEmptyEmail();
        Assert.assertEquals(buttonConfirmEmptyEmail.isDisplayed(), true);
    }

    @Test(description = "TestSendEmptyBodyEmail", dependsOnMethods = "testConfirmEmptyBodyEmailForm")
    public void testSendEmptyBodyEmail() {
        app.confirmSendEmptyEmail.confirmSendEmptyEmail();
        String partOfExpectedSuccessfulMessage = "\u0412" + "\u0430" + "\u0448" + "\u0435"; //Ваше
        Assert.assertEquals(app.confirmationSuccessSendEmail.getSuccessfulTextSendEmail().getText().substring(0, 4), partOfExpectedSuccessfulMessage);
    }

    @Test(description = "IsThereEmailInEmailList", dependsOnMethods ="testSendEmptyBodyEmail")
    public void testPresentSentEmail() {
        app.mailMain.goToInbox();
//        driver.navigate().refresh();
        app.mailMain.refresh();
        String expectedSubject = app.mailMain.getEmailSubject().getText();
        Assert.assertTrue(expectedSubject.contains(emailSubject),
                "There is no sent email with subject: \"AKhudyakov's test email\"");
        Assert.assertEquals(app.mailMain.countEmailsWithSubject(),1);
    }
}
