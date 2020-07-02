package cn.sxt.oo;

public class TestClass {
    int e;
    public int f;
    private int g;
    protected int h;
    public static void main(String[] args){
        Human H = new Human();
        H.a = 10;
        //H.b = 10 //私有属性类外不可访问
        H.d = 20;
        H.c = 20;
        Teacher T = new Teacher();
        T.a = 20;
        //T.b = 20;
        T.c =30;
        T.d = 40;
    }
}

class Human{
    int a;
    private int b;
    public int c;
    protected int d;
}

class Teacher extends Human{
    public Teacher(){}
    public Teacher(int _a, int _b, int _c, int _d){
        a = _a;
        //b = _b;不能继承父类的私有属性
        //super.b = _b; 用super也不能访问父类的私有属性
        c = _c;
        d = _d;
    }
}

