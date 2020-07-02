import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
public class TestArray {
    public static void main(String[] args){
        int[] a = new int[4];
        a[0] = 10; a[1] = 20; a[2] = 30; a[3] = 50;
        for(int i:a)System.out.println(i);
        System.out.println(a.toString());
        System.out.println(a.length);
        System.out.println(a.clone() + ""+a);
        int[] b = a.clone();
        System.out.println(a.equals(b));
        //int[] c = new int(a.length);不可以用变量
        Arrays.sort(a,1,2);
        Arrays.parallelSort(b);
        System.out.println((Arrays.toString(a)) instanceof String);
        Arrays.fill(a,2);
        System.out.println(Arrays.toString(a));
        int[] d = Arrays.copyOf(a,3);
        System.out.println(Arrays.toString(d));
        int[] e = Arrays.copyOfRange(a,1,3);
        System.out.println(Arrays.toString(e));
        int[][]s = new int[4][];
        s[0] = new int[]{1,2,3,4};
        s[1] = new int[]{5,6};
        s[2] = new int[]{7,8};
        s[3] = new int[4];
        s[3][0] = 12;
        s[3][1] = 13;
        s[3][2] = 14;
        System.out.println(Arrays.deepToString(s));
//        for(int i=10;i<Integer.MAX_VALUE;i*=10)
//            test(i);
    }
    public static void test(long limit){
        Random rand = new Random();
        IntStream stream = rand.ints(limit);
        int[] arr = stream.toArray();
        int[] arr1 = Arrays.copyOf(arr, arr.length);

        long t1 = System.currentTimeMillis();
        Arrays.parallelSort(arr);
        long t2 = System.currentTimeMillis();
        Arrays.sort(arr1);
        long t3 = System.currentTimeMillis();
        System.out.println("limit:"+limit+"\t parallelSort: "+(t2-t1)+"ms\tserialSort: "+(t3-t2)+"ms");
    }
}


