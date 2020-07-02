package com.thread;

public class JavaThread {
    public static void main(String[] args) {
        Thread t4 = new Thread(()->{
            while (true){
                System.out.println(44444);
            }
        });
        t4.setDaemon(true);
        t4.start();
        Thread t1= new Thread(new Run1(), "111");
        Thread t2= new Thread(new Run1(), "222");
        Thread t3= new Thread(new Run1(), "333");
        t1.setPriority(3);
        t2.setPriority(6);
        t3.setPriority(9);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Run1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
//            Thread.yield();
        }
    }
}
