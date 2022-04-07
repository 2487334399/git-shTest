package at.Lx;

public class MailSender implements  Sender{
    @Override
    public void Send() {
        System.out.println("this is a senderMail");
    }
}
