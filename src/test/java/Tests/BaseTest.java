package Tests;

import Utils.EmailFactory;
import Utils.User;
import Utils.UserFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by adminnt on 28.04.17.
 */
public class BaseTest {

    MyApplication app = new MyApplication();
    User validUser;
    User nonExistingdUser;
    User invalidPasswordUser;
    String emailSubject;
    String emailReceiver;

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before Suit");
        validUser = UserFactory.getValidUser();
        nonExistingdUser = UserFactory.getNonExistingUser();
        invalidPasswordUser = UserFactory.getInvalidPasswordUser();
        emailSubject = EmailFactory.getEmail().subject;
        emailReceiver = EmailFactory.getEmail().receiverName;
        app.common.appStart();
    }

    @AfterSuite
    public void afterSuite() {
        app.common.appStop();
    }

}
