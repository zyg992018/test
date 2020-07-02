import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.io.InputStream;

public class TestTerminateThread {
    public static void main(String[] args){
        TerThread T = new TerThread();
        Thread t = new Thread(T);
        t.start();
        InputStream i = System.in;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T.stop();
    }
}

class TerThread implements Runnable{
    private boolean flag = true;

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        while (flag){
            System.out.println("线程调用中。。。。。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
