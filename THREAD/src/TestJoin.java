public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int j =0;j<= 100;j++){
                System.out.println(j);
            }
        });
        t.start();
        for(int i = 0;i <= 100;i++ ){
            System.out.println(i);
            if(i ==20){
                t.join();
            }
        }
    }
}
