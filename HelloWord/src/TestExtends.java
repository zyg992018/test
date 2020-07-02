/**
 * 测试继承
 */
public class TestExtends {
    public static void main(String[] args){
        Person p1 = new Person("张三",17);
        p1.play();
        Student s1 = new Student("李四", 20, "123456");
        s1.play();
        Person p2 = (Person)new Student("王二",30, "12345367");
        p2.play();
        System.out.println(p2 instanceof Student);
        System.out.println(p2.equals(s1));
        System.out.println(p1.equals(p1));
        Student s2 = new Student("李四", 20, "123456");
        System.out.println(s2.equals(s1));
        System.out.println(s2.getClass()+ s2.toString());
    }
}

class Person {
    String name;
    int age;
    public Person(String _name, int _age){
        name = _name;
        age = _age;
    }
    public Person(){}
    public void play(){
        System.out.println("我是"+name+",我今年"+age+"岁了");
    }
    public Person get() {
        return this;
    }
}

class Student extends Person{
    String num;
    public Student(String _name, int _age, String _num){
        super(_name,_age);
        num =_num;
    };
    public void play(){
        System.out.println("我是"+name+",我今年"+age+"岁了"+"我的学号是"+num);
    }
    public Student get(){
        return this;
    }
    public boolean equals(Object obj){
        if(obj == this)return true;
        if(!(obj instanceof Student))return false;
        Student objs = (Student)obj;
        if(!this.name.equals(objs.name) || this.age != objs.age || !this.num.equals(objs.num) )return false;
        return true;
    }
}