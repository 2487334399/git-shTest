package at.Lx1;

public class SendFactory {

    public Sender mailSender(){
        return new MailSender();
    }
    public Sender ssmSender(){
        return new SsmSender();
    }
}
