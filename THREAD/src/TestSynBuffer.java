public class TestSynBuffer {
    public static void main(String[] args){
        Container c = new Container();
        Consumer c1 = new Consumer(c);
        Store s = new Store(c);
        new Thread(s).start();
        new Thread(c1).start();
    }
}

class Consumer implements Runnable{
    Container c;
    public Consumer(Container c){
        this.c = c;
    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {

            System.out.println("这是我吃的第" + c.pop().id + "馒头");
        }
    }
}

class Store implements  Runnable{
    Container c;
    public Store(Container c){
        this.c = c;
    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){

            c.push(new SteamedBun(i));
            System.out.println("这是第"+i+"馒头");
        }
    }
}

class Container{
    SteamedBun[] s;
    int size = 10;
    public Container(){
        s = new SteamedBun[10];
        size = 0;
    }
    public synchronized void push(SteamedBun i){
        if(size == s.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        s[size++]  = i;
        this.notifyAll();
    }
    public synchronized SteamedBun pop(){
        if (size == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size--;
        this.notifyAll();
        return s[size];
    }
}

class SteamedBun{
    int id;
    public SteamedBun(int id){
        this.id = id;
    }
}