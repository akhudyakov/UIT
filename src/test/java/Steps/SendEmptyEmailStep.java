package Steps;

import Pages.SendEmailPage;
import Utils.EmailFactory;

/**
 * Created by Andrey on 02.06.2017.
 */
public class SendEmptyEmailStep extends SendEmailPage {

    public void sendEmptyEmailWithSubject () {
     sendEmptyBodyEmail(EmailFactory.getEmail().subject);
    }
}

