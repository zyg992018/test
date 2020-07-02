import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args){
//        test01();
        test02();
    }

    public static void test01(){
        ArrayList<String> l1 = new ArrayList<>();
        System.out.println(l1.size());
        l1.add("aa");
        l1.add("bb");
        l1.add("cc");
        System.out.println(l1.size());
        System.out.println(l1.isEmpty());
        System.out.println(l1.get(0));
        System.out.println(l1.indexOf("aa"));
        System.out.println(l1.remove(2));
        l1.add("cc");
        l1.add("cc");
        l1.remove("cc");
        System.out.println(l1.toString());
        l1.set(2,"dd");
        System.out.println(l1.contains("dd"));
        ArrayList<String> o = (ArrayList)l1.clone();
        System.out.println(o.toString());
        List<String> l3 = l1.subList(0,2);
        System.out.println(l3.toString());
        l1.clear();
    }

    public static void test02(){
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("aa");
        l1.add("bb");
        l1.add("cc");
        l1.add("dd");
        l1.add("aa");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("aa");
        ArrayList<String> l3 = new ArrayList<>();
        l3.add("cc");
        l3.add("ee");
        System.out.printf("l1:%s l2:%s l3:%s\n",l1.toString(),l2.toString(),l3.toString());
        System.out.println(l1.containsAll(l2)+"  "+l1.containsAll(l3));
        l1.addAll(l3);
        System.out.printf("l1:%s l2:%s l3:%s\n",l1.toString(),l2.toString(),l3.toString());
        l1.removeAll(l2);
        System.out.printf("l1:%s l2:%s l3:%s\n",l1.toString(),l2.toString(),l3.toString());
        ArrayList<String> l4 = new ArrayList<>(10);
    }
}
