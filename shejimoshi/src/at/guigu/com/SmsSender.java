package at.guigu.com;

public class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is a Smsender");
    }
}
