package many.factory;

import at.guigu.com.Sender;
import at.guigu.com.SenderFactory;

public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sendFactory=new SendFactory();

        Sender sender=sendFactory.produceMail();
        sender.send();
    }
}
