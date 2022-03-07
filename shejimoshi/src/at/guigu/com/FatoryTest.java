package at.guigu.com;

public class FatoryTest {

    public static void main(String[] args) {
        SenderFactory senderFactory=new SenderFactory();
        Sender sender=senderFactory.produce("sms");
        sender.send();
    }
}
