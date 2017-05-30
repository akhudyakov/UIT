package Utils;

/**
 * Created by Andrey on 28.05.2017.
 */
public class Email{

    public String receiverEmail;
    public String receiverName;
    public String subject;
    public String content;

    public Email() {
    }

    public Email(String receiverEmail, String subject) {
        this.receiverEmail = receiverEmail;
        this.subject = subject;
    }

    public Email(String receiverEmail, String receiverName, String subject) {
        this.receiverEmail = receiverEmail;
        this.receiverName = receiverName;
        this.subject = subject;
    }
}
