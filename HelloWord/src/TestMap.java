import java.util.HashMap;

public class TestMap {
    public static void main(String[] args){
       //test01();
//        test02();
        test03();
    }

    public static void test01(){
        HashMap<String,String> m = new HashMap<>();
        m.put("张三","我叫张三，我喜欢打篮球");
        m.put("李四","我叫李四，我喜欢敲代码");
        m.put("王五","我叫王五，我喜欢打游戏");
        m.put("小红","我叫小红，我喜欢唱歌");
        m.put("小明","我叫小明，我喜欢跳舞");
        System.out.println(m.get("小红"));
        System.out.println(m.containsKey("小明"));
        System.out.println(m.containsValue("我喜欢打游戏"));
        System.out.println(m.toString());
        System.out.println(m.size());
        System.out.println(m.values());
        System.out.println(m.remove("小红","我喜欢画画"));
        System.out.println(m.replace("小红","我喜欢画画"));
        System.out.println(m.replace("小红","我喜欢画画","我喜欢跳舞"));
        System.out.println(m.toString());
    }

    public static void test02(){
        HashMap<Integer,String> h = new HashMap<>();
        h.put(1,"aa");
        h.put(2,"bb");
        h.put(3,"cc");
        h.put(4,"dd");
        HashMap<Integer,String> h1 = new HashMap<>();
        h1.put(1,"ff");
        h1.put(5,"gg");
        h1.put(6,"ee");
        h1.put(3,"hh");
        h.putAll(h1);
        System.out.println(h);
        System.out.println(h.hashCode());
    }

    public static void test03(){
        String a = new String("aa");
        HashMap<String,String> m = new HashMap<String,String>();
        m.put(a,"aaaa");
        String b = new String("aa");
        m.put(b,"bbbb");
        System.out.println(m.toString());
        System.out.println();
    }
}
