package cn.sxt.oo;
import cn.sxt.oo.TestClass;

public class TestClass2 {
    public static void main(String[] args){
        Human H = new Human();
        H.a =20;
        //H.b = 20;不同的包不能访问私有属性
        H.c = 40;
        H.d = 40;
    }
}
