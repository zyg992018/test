public class TestRace {
    public static void main(String[] args){
        Race r = new Race();
        Thread t = new Thread(r,"兔子");
        Thread t2 = new Thread(r,"乌龟");
        t2.start();
        t.start();
    }
}

class Race implements Runnable{
    private static  String winner = null;
    int steps = 0;
    @Override
    public void run() {
        for(int i = 0; i <= 1000; i++) {
            String s = Thread.currentThread().getName();
            if(s.equals("兔子")&&((steps%10)==0)){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                steps++;
                System.out.println( s+ "--->" + steps);
            }
            if (isOver()) {
                break;
            }
        }
    }
    public boolean isOver(){
        if(winner!=null)return true;
        if(steps == 1000){
            winner = Thread.currentThread().getName();
            System.out.println(winner+"胜利了");
            return true;
        }
        return false;
    }

}

