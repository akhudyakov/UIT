package Steps;

import Pages.LoginPage;
import Utils.UserFactory;

/**
 * Created by Andrey on 01.06.2017.
 */
public class LoginStep extends LoginPage {

    public void loginValidUser() {
        login(UserFactory.getValidUser());
    }

    public void loginNonExistingUser() {
        login(UserFactory.getNonExistingUser());
    }

    public void loginValidUserInvalidPassword() {
        login(UserFactory.getInvalidPasswordUser());
    }
}
