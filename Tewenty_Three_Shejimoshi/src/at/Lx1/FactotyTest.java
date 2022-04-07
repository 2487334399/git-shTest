package at.Lx1;

public class FactotyTest {

    public static void main(String[] args) {
        SendFactory factory=new SendFactory();
        Sender sender= factory.ssmSender();
        sender.Send();
    }

}
