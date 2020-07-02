public class TestIf {
    public static void main(String[] args){
        int dd = (int)(6*Math.random()+1);
        System.out.println(dd);
        if(dd <= 3)System.out.println("小");
        else System.out.println("大");
        int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0;
        for(int i = 0; i < 100000; i++){
            int temp = (int)(6*Math.random()+1);
            switch(temp){
                case 1: a++;break;
                case 2: b++;break;
                case 3: c++;break;
                case 4: d++;break;
                case 5: e++;break;
                case 6: f++;break;
            }
        }
        double count = 100000.0;
        System.out.println(a/count + "  " + b/count+ "  " + c/count+ "   " + d/count+ "  " + e/count+ "  " + f/count);
    }
}
