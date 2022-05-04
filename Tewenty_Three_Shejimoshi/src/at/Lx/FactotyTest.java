package at.Lx;

public class FactotyTest {

    public static void main(String[] args) {
        SendFactory factory=new SendFactory();
        Sender sender=factory.produce("Mail");
        sender.Send();
    }

}
