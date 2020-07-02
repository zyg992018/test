import java.util.concurrent.*;

public class TestCallAble {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test02();
    }
    public static void test01(){
        CallAble a = new CallAble(20);
        CallAble b = new CallAble(19);
        a.call();
        b.call();
        ExecutorService E = Executors.newFixedThreadPool(2);
        Future<Boolean> res1 = E.submit(a);
        Future<Boolean> res2 = E.submit(b);
        try {
            Boolean res = res1.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        E.shutdown();
    }
    public static void test02() throws ExecutionException, InterruptedException {
        Call a = new Call("兔子");
        Call b = new Call("乌龟");
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Future<Integer> res1 = ser.submit(a);
        Future<Integer> res2 = ser.submit(b);
        System.out.println(res1.get()+"  "+res2.get());
        ser.shutdown();
    }
}

class CallAble implements Callable<Boolean> {
    int a ;
    public CallAble(int _a){a=_a;}
    public Boolean call(){
        if(a==20) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(a);
        return a == 20;
    }
}

class Call implements Callable<Integer>{
    private static String winner;
    int steps = 0;
    String name;
    public Call(String name){
        this.name = name;
    }
    public Integer call(){
        for(int i =1; i <=100; i++) {
            if (winner != null) return steps;
            if((i%10==0)&&name.equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(++steps);
            if(steps==100){
                winner = name;
                System.out.println(name+"胜利了");
            }
        }
        return steps;
    }
}