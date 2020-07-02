public class TestClass {
    int age;
    String name;
    String favor;
    static int count;
    void Study(){
        System.out.printf("我是%s,我爱学习%s\n",name,favor);
    }
    void play(){
        System.out.println("我喜欢打篮球");
    }
    //静态构造
    static{
        System.out.println("静态构造");
        count = 0;
    }
    //构造函数
    public TestClass(int _age, String _name, String _favor){
        //super();//编译默认添加
        System.out.println("这是第"+(++count)+"对象");
        age = _age;
        name = _name;
        favor = _favor;
    }
    //显示定义构造函数后，系统将不再构造默认的构造函数
    public TestClass(){}//默认的构造函数
    public static void main(String[] args){
        TestClass S = new TestClass(12, "张三", "计算机");
        S.play();
        S.Study();
        TestClass U = S;
        U.play();
        U.Study();
        U.name = "李明";
        U.Study();
        S.Study();
        TestClass V = new TestClass();
        V = S;
        V.Study();
        V.name = "小V";
        S.Study();//对象都是对象的首地址
    }
}
