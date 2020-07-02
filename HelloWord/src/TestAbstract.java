public class TestAbstract {
    public static void main(String[] args){
        //A s = new A(); 抽象类没有实例
        B b = new B();
        b.test();
    }
}
//构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
abstract class  A{
    abstract void test();
    //abstract ();构造方法不能声明为抽象方法。
    //abstract static print();用 static 修饰的方法不能声明为抽象方法。
    void print(){
        System.out.println("qqqqqq");
    }
}

class B extends A{
    void test(){
        System.out.println("你好！");
    }
}
