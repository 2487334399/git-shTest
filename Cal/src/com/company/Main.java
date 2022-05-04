package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 创建可中断的线程实例
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("thread 执行步骤1：线程即将进入休眠状态");
                try {
                    // 休眠 1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("thread 线程接收到中断指令，执行中断操作");
                    // 中断当前线程的任务执行
                    break;
                }
                System.out.println("thread 执行步骤2：线程执行了任务");
            }
        });
        thread.start(); // 启动线程

        // 休眠 100ms，等待 thread 线程运行起来
        Thread.sleep(100);
        System.out.println("主线程：试图终止线程 thread");
        // 修改中断标识符，中断线程
         thread.interrupt();
    }
}
