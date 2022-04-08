package at.Lx3;

public class SendMailFactoty implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
