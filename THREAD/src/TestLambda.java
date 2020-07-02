public class TestLambda {
    //静态内部类，不编译
    static class T extends Thread{
        @Override
        public void run() {
            System.out.println("aaaaaa");
        }
    }
    public static void main(String[] args){
        //局部内部类，不编译
        class Run2 implements Runnable{

            @Override
            public void run() {
                System.out.println("bbbbbbbb");
            }
        }

        T t = new T();
        t.start();
        Thread t1 = new Thread(new Run2());
        t1.start();
        //Lambda表达式
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("cccccccccccc");
            }
        }) ;
        t2.start();
        //Lambda表达式简化版
        Thread t3 = new Thread(()->{
            System.out.println("dddddddd");
        });
        t3.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你好呀");
        /********************
         * 测试Lambda
         */
        Inn l1 = (a,b)->{
            return a+b;
        };
        Inn l2 = (a,b)-> a+b;
        In l3 = a->{ return a;};
        l1.play(1,2);
        l2.play(2,3);
        l3.play(1);
    }

}

interface  In{
    int play(int a);
}

interface Inn{
    int play(int a, int b);
}





