package com.cn.Test;

import com.cn.Cls.fruitSale;
import com.cn.Inter.Sale;

import java.util.concurrent.*;

public class testCase {

    public static void main(String[] args) {
        Sale sale=new fruitSale();
        // 自定义连接池
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5,
                2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("自定义拒绝策略");
                    }
                }
        );

        try {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "做水果销售"+sale.obPreSale());
                });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }



}
