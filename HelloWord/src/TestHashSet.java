import cn.sxt.myCollenction.MyHashSet;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        for(String i : set)
            System.out.println(i);
        MyHashSet<String> m = new MyHashSet<>();
        m.add("eee");
        m.add("fff");
        m.add("ggg");
        m.add("hhh");
        System.out.println(m);
    }

}

