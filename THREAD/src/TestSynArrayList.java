import java.util.ArrayList;

public class TestSynArrayList {
    public static void main(String[] args){
        Run11 r = new Run11();
        Thread t = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        t.start();
        t2.start();
        t3.start();
    }
}

class Run11 implements Runnable{
    private ArrayList<Integer> list;
    public Run11(){ list = new ArrayList<>(); }
    @Override
    public void run() {
        synchronized (list) {
            if (list.size() >= 1000) {
                System.out.println(list.size());
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1000; i > 0; i--) {
                list.add(i);
            }
        }
    }
}