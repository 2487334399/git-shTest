package com.cn;

public class Ticket {
    //票数
    private  int number=30;
    //操作方法，买票
    public void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"：卖出："+(number--)+"剩下:"+number);

        }
    }
}
