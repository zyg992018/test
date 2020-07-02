public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread g = new Thread(new God(),"God");
        g.setDaemon(true);
        g.start();
        Thread y = new Thread(new Yous(),"You");
        System.out.println(g.isAlive());
        y.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println(g.isAlive());
        System.out.println(y.isAlive());
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for(;true;){
            System.out.println("Good!");
        }
    }
}
class Yous implements Runnable{
    @Override
    public void run() {
        for(int i =100;i>0;i--){
            System.out.println("You!");
        }
    }
}



