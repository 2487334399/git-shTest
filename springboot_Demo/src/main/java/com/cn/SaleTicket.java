package com.cn;


public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用买票方法
                ticket.sale();
                }
            },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40; i++) {
                    ticket.sale();
                }
            }
          },"BB").start();
        }
    }
