public class TestYield {
    public static void main(String[] args){
        R a = new R();
        Thread r1 = new Thread(a,"a");
        Thread r2 = new Thread(a,"b");
        r1.start();
        r2.start();
    }
}

class R implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
