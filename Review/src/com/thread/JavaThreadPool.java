package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaThreadPool {
    static Integer  tick = 100;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (tick) {
                    while (tick > 0) {
                        tick--;
                        System.out.println("剩余" + tick);
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (tick) {
                    while (tick > 0) {
                        tick--;
                        tick--;
                        System.out.println("还剩余" + tick);
                    }
                }
            }
        };
        es.submit(runnable);
        es.submit(runnable);
        es.submit(runnable2);
        es.submit(runnable2);
        es.shutdown();
    }

}
