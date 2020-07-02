public class TestPriority {
    public static void main(String[] args){
        Thread t = new Thread(new Run(),"1");
        Thread t1 = new Thread(new Run(),"2");
        Thread t2 = new Thread(new Run(),"3");
        Thread t3 = new Thread(new Run(),"4");
        Thread t4 = new Thread(new Run(),"5");
        Thread t5 = new Thread(new Run(),"6");
        t.setPriority(10);
        t1.setPriority(9);
        t2.setPriority(8);
        t3.setPriority(1);
        t4.setPriority(5);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}


class Run implements Runnable{
    @Override
    public void run() {
        Thread.yield();
        System.out.println(Thread.currentThread().getState()+Thread.currentThread().getName());
    }
}