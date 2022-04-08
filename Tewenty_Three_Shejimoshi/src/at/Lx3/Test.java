package at.Lx3;

public class Test {

    public static void main(String[] args) {
        Provider provider=new SendMailFactoty();
        Sender sender=provider.produce();
        sender.send();
    }
}
