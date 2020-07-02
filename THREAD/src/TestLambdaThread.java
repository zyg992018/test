public class TestLambdaThread {
    public static void main(String[] args){
        new Thread(()->{
            System.out.println("唱歌");
        }).start();
        new Thread(()->System.out.println("跳舞")).start();

    }
}

