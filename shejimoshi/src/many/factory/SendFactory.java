package many.factory;

import at.guigu.com.MailSender;
import at.guigu.com.Sender;
import at.guigu.com.SmsSender;

public class SendFactory {

    public Sender produceMail(){

        return new MailSender();

    }
    public Sender produceSms(){

        return new SmsSender();

    }
}
