package Tests;

import Steps.*;

/**
 * Created by Andrey on 31.05.2017.
 */
public class MyApplication {

    CommonStep common = new CommonStep();
    LoginStep login = new LoginStep();
    MailStep mailMain = new MailStep();
    SendEmptyEmailStep sendEmptyEmail = new SendEmptyEmailStep();
    SelectContactStep selectContact = new SelectContactStep();
    ConfirmSendEmptyEmailStep confirmSendEmptyEmail = new ConfirmSendEmptyEmailStep();
    ConfirmationSuccessSendEmailStep confirmationSuccessSendEmail = new ConfirmationSuccessSendEmailStep();
}
