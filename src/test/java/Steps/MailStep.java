package Steps;

import Pages.MailPage;
import Utils.EmailFactory;

/**
 * Created by Andrey on 01.06.2017.
 */
public class MailStep extends MailPage {

    public void deleteEmailsWithSubject() {
        deleteRemainedTestEmailsWithSubject(EmailFactory.getEmail().subject);
    }

    public int countEmailsWithSubject() {
        return countEmailsWithSubject(EmailFactory.getEmail().subject);
    }
}
