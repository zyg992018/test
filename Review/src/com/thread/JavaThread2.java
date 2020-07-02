package com.thread;

public interface JavaThread2 {
    public static void main(String[] args) throws InterruptedException {
        BanCard banCard = new BanCard(0);
        new Save(banCard,90).start();
        new Save(banCard,90).start();
        new Save(banCard,90).start();
        new Save(banCard,90).start();
        new Save(banCard,90).start();
        new Save(banCard,90).start();

        new Take(banCard,90).start();
        new Take(banCard,90).start();
        new Take(banCard,90).start();
        new Take(banCard,90).start();
        new Take(banCard,90).start();
        new Take(banCard,90).start();
        Thread.sleep(1000);
        System.out.println(banCard.getMoney());
    }
}

class Save extends Thread{
    BanCard banCard;
    double m;
    public Save(BanCard banCard,double m) {
        this.banCard = banCard;
        this.m = m;
    }

    @Override
    public void run() {
        banCard.save(m);
    }
}

class Take extends Thread{
    BanCard banCard;
    double m;
    public Take(BanCard banCard,double m) {
        this.banCard = banCard;
        this.m = m;
    }

    @Override
    public void run() {
        banCard.take(m);
    }
}
class BanCard{
    private double money =0;

    public BanCard(double money) {
        this.money = money;
    }

    public synchronized void save(double m) {
        money+=m;
        this.notifyAll();
    }
    public synchronized void take(double m) {
        while (money<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money-=m;
    }

    public double getMoney() {
        return money;
    }
}