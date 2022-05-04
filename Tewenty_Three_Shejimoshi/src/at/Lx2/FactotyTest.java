package at.Lx2;

import at.Lx1.Sender;

public class FactotyTest {

    public static void main(String[] args) {
         Sender sender=SendFactory.produceSsmSender();
         sender.Send();
    }

}

