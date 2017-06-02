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

    public static User getValidUser() {
        return new User(user.getString("valid.username"),user.getString("valid.password"),
                user.getString("valid.email"));
    }

    public static User getNonExistingUser() {
        return new User(user.getString("nonexistent.username"),user.getString("valid.password"),
                user.getString("invalid.email"));
    }

    public static User getInvalidPasswordUser() {
        return new User(user.getString("valid.username"),user.getString("invalid.password"),
                user.getString("valid.email"));
    }
}
