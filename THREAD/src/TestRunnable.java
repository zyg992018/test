public class TestRunnable {
    public static void main(String[] args){
       test02();
    }
    public static void test01(){
        Thread t = new Thread(new MyRunnable());
        t.start();
        for (int i =0; i< 100; i++){
            System.out.println("主线程"+i);
        }
    }
    public static void test02(){
        Integer i = new Integer(0);
        MyRunnable1 m = new MyRunnable1(i);
        Thread t = new Thread(m,"一");
        Thread t2 = new Thread(m,"二");
        Thread t3 = new Thread(m,"三");
        t.start();
        t2.start();
        t3.start();
    }
}

class MyRunnable implements Runnable{
    public void run(){
        for(int i =10; i< 100;i++){
            System.out.println("次线程"+i);
        }
    }
}

class MyRunnable1 implements Runnable{
    Integer i ;
    @Override
    public void run() {
        for(int _i = 0; _i <10000;_i++){
            i = i+1;
            System.out.println(i+"--->"+Thread.currentThread().getName());
        }
    }
    public MyRunnable1(Integer _i){
        this.i = _i;
    }
}
