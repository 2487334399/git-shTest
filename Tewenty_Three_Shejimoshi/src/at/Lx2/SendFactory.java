package at.Lx2;

import at.Lx1.Sender;
import at.Lx1.SsmSender;

public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSsmSender(){
        return new SsmSender();
    }
}
