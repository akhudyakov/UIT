package Utils;

import java.util.ResourceBundle;

/**
 * Created by Student on 27.05.2017.
 */
public class EmailFactory {

    //    User user;
    static ResourceBundle email = ResourceBundle.getBundle("Email");
    /*static {
      user = ResourceBundle.getBundle("User");
    }*/

    public static Email getEmail() {
        return new Email(email.getString("receiverEmail"),email.getString("receiverName"),email.getString("subject"));
    }
}
