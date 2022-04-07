package at.Lx;

public class SendFactory {

    public Sender produce(String type){
        if("Mail".equals(type)){
            return new MailSender();
        }else if("Ssm".equals(type)){
            return new SsmSender();
        }else{
            System.out.println("输入正确的类型");
            return null;
        }
    }
}
