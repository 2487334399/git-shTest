package at.Lx3;

public class SendSsmFactory implements Provider{
    @Override
    public Sender produce() {
        return new SsmSender();
    }
}
