public class TestSynsingal {
    public static void main(String[] args){
        TV t = new TV();
        new Actor(t).start();
        new Watcher(t).start();
    }
}

class TV{
    String voice;
    Boolean flag = true;
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("表演了:"+voice);
        flag = !flag;
        this.notifyAll();
    }
    public synchronized void visit(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了"+voice);
        flag = !flag;
        this.notifyAll();
    }
}

class Actor extends Thread{
    TV t;
    public Actor(TV t){
        this.t = t;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++ ){
            t.play("你好！"+i);
        }
    }
}
class Watcher extends Thread{
    TV t;
    public Watcher(TV t){
        this.t = t;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++ ){
            t.visit();
        }
    }
}