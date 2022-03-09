package at.guigu.com;

public class FatoryTest {

    public static void main(String[] args) {
        SenderFactory senderFactory=new SenderFactory();
        Sender sender=senderFactory.produce("Sms");
        sender.send();
        System.out.println("成功输入正确的类型");
    }
}
