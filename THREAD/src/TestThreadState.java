public class TestThreadState {
    public static void main(String[] args){
//        test01();
        test02();
    }
    public static void test01(){
        Thread.State state = null;
        Thread t = new Thread(
            ()->{
                for(int  i =0; i < 100;i++){
                    System.out.println("aaaa");
            }
        });
        state = t.getState();
        System.out.println(state);
        t.start();
        System.out.println(state);
        while(state!=Thread.State.TERMINATED){
            state = t.getState();
            System.out.println(t.getState());
        }
    }
    public static void test02(){
        Thread.State state = null;
        Thread t = new Thread(()->{
            for(int  i =0; i < 100;i++){
                System.out.println("aaaa");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        state = t.getState();
        System.out.println(state);
        t.start();
        System.out.println(Thread.activeCount());
        while(Thread.activeCount()!=2){
            state = t.getState();
            System.out.println(state);
            System.out.println(Thread.activeCount());
        }
    }
}
