import java.security.PublicKey;

public class TestSyn {
    public static void main(String[] args){
//       test01();
        test02();
    }
    public static void test01(){
        Run10 r = new Run10();
        Thread t = new Thread(r,"you");
        Thread t1 = new Thread(r,"I");
        Thread t2 = new Thread(r,"He");
        t.start();
        t1.start();
        t2.start();
    }
    public static void test02(){
       User u = new User();
       Run12 r = new Run12(u,80);
       Run12 r1 = new Run12(u,80);
       Thread t1 = new Thread(r,"你");
       Thread t2 = new Thread(r1,"他");
       t1.start();
       t2.start();
    }
}
class  Run10 implements Runnable{
    private  int ticketNum = 10000000;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }
    public synchronized void test(){
        if(ticketNum<=0){
            flag  = false;
            return;
        }
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println((Thread.currentThread().getName()+"--->")+ticketNum--);
    }
}

class User{
    int money=100;
}
class Run12 implements Runnable{
    User account;
    int drawingMoney;
    int packetTotal;
    public Run12(User account,int drawingMoney){
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        synchronized (account) {
            if(account.money-drawingMoney<0){
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                account.money -= drawingMoney;
                packetTotal += drawingMoney;
        }
        System.out.println(Thread.currentThread().getName()+"-->账户余额："+account.money);
        System.out.println(Thread.currentThread().getName()+"-->口袋钱为："+packetTotal);
    }
}