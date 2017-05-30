package Utils;

import java.util.ResourceBundle;

/**
 * Created by Student on 27.05.2017.
 */
public class UserFactory {

    static ResourceBundle user = ResourceBundle.getBundle("User");
    /*static {
      user = ResourceBundle.getBundle("User");
    }*/

    public User getValidUser() {
        return new User(user.getString("valid.username"),user.getString("valid.password"),
                user.getString("valid.email"));
    }
}
