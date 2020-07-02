
public class TestWrapperClass {
    public static void main(String[] args){
        Integer a = new Integer(13);
        Integer b = new Integer("12");
        Integer c = Integer.valueOf(12);
        Integer d = a + b;
        System.out.println(d);
        int g = c;
        g = a.intValue();
        g = b;
        double f = b.doubleValue();
        System.out.println(g+f);
        d = Integer.parseInt("12345");
        System.out.println(d);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.decode("123") == 123);
        System.out.println((new Integer(12)) == 12);
        System.out.println(b.equals(12));
        Object S = 12;
        System.out.println(S instanceof Integer);
        //Integer类的cache缓存范围[-128,127]
        Integer A = -128;
        Integer B = -128;
        System.out.println(A == B);//在cache 范围类是同一个对象
        Integer C = new Integer(-128);
        Integer D = Integer.valueOf(-128);
        System.out.println(A==D);//valueOf创建的也一样
        System.out.println(A == C);//new出来的对象不一样
    }
}
