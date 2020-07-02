public class TestString {
    public static void main(String[] args){
        String S1 = "asdsa";
        String S2 = "asdsa";
        System.out.println(S1.charAt(1));
        System.out.println(S1.toString());
        System.out.println(S1.length());
        System.out.println(S1.indexOf('s'));
        System.out.println(S1.indexOf("sd"));
        System.out.println(S1.indexOf("23"));
        System.out.println(S1.equals("asdsa"));
        System.out.println(S1 == S2);//字符串常量相同的是同一个地址，new出来的是不一样的
        System.out.println(S1.hashCode() == S2.hashCode());
        System.out.println(S1.indexOf('s',2));//从哪里开始匹配
        System.out.println(S1.equalsIgnoreCase("AsDSa"));
        System.out.println(S1.replace('s','w'));//返回新的字符串，原字符串不变
        System.out.println(S2+"  "+S1);
        System.out.println(S1.startsWith("as"));
        System.out.println(S1.endsWith("sa"));
        System.out.println(S1.substring(2)+"  "+S1.substring(1,4));//不包括4
        System.out.println(S1.toUpperCase());
        System.out.println(S1.toUpperCase().toLowerCase());
        System.out.println((S1+"  ").trim());//去掉首尾空格

    }
}
