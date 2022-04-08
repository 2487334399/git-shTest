package at.Lx2;

import at.Lx1.Sender;

public class MailSender implements Sender {
    @Override
    public void Send() {

        System.out.println("this is a senderMail");
    }
}
