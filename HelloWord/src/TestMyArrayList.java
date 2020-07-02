import cn.sxt.myCollenction.MyArrayList;

public class TestMyArrayList {
    public static void main(String[] args){
        MyArrayList<String> m = new MyArrayList<>();
        m.add("aa");
        m.add("bb");
        m.add("cc");
        m.add("dd");
        m.add("ee");
        System.out.println(m);
        System.out.println(m.indexOf("aa"));
        System.out.println(m.lastIndexOf("cc"));
        m.add(2,"ff");
        m.add(0,"gg");
        m.add(7,"gg");
        m.add(7,"gg");
        m.add(7,"gg");
        m.add(7,"gg");
        m.add(7,"gg");
        System.out.println(m);
        m.remove("gg");
        m.remove(0);
        m.remove(m.size()-1);
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}
