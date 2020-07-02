public class TestThread {
    public static void main(String[] args){
        MyThread m1 = new MyThread();
        m1.start();
        for(int i = 1; i < 20; i++){
            System.out.println("主线程第"+i+"次");
        }
    }
}
class MyThread extends Thread{
    public void run(){
        for(int i = 1; i <= 20; i++){
            System.out.println("第"+i+"次");
        }
    }
}
