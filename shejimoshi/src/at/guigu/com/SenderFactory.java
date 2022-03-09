package at.guigu.com;

public class SenderFactory {

    public Sender produce(String type){

            if("email".equals(type)){
                return new MailSender();
            }else if("Sms".equals(type)){
                return new SmsSender();
            }else{
                System.out.println("输入正确的类型");
                return null;
            }
        }
}
