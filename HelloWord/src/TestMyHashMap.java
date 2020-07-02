import cn.sxt.myCollenction.MyHashMap;

public class TestMyHashMap {
    public static void main(String[] args){
        MyHashMap<String,String> m = new MyHashMap<>();
        m.put("1","李明");
        m.put("3","bb");
        m.put("4","cc");
        m.put("5","dd");
        m.put("6","ee");
        m.put("7","ff");
        m.put("8","gg");
        m.put("9","hh");
        m.put("10","jj");
        m.put("11","ii");
        m.put("12","kk");
        m.put("13","ll");
        m.put(new String("1"),"aaaa");
        System.out.println(m.toString());
//        System.out.println(m.get("2"));
//        System.out.println(m.get("3"));
//        System.out.println(m.get("13"));
//        System.out.println(m.containsKey("12"));
//        System.out.println(m.containsKey("2"));
//        System.out.println(m.containsValue("ll"));
//        System.out.println(m.containsValue("mm"));
        System.out.println(m.remove("11"));
        System.out.println(m.remove("1"));
        System.out.println(m.remove("2"));
        System.out.println(m.remove("3"));
        System.out.println(m.remove("4"));
        System.out.println(m.remove("5"));
        System.out.println(m.toString());
    }
}
