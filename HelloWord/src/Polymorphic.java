public class Polymorphic {
    public static void main(String[] args){
        Animal A = new Animal();
        Cat C = new Cat();
        Dog D = new Dog();
        D.color = "黄色";
        shout(A);
        shout(C);
        shout(D);
        Animal AD = (Animal)D;
        AD.shout();
        D = (Dog)AD;
        System.out.println(D.color);
    }
    public static void shout(Animal A){
        A.shout();
    }
}


class Animal{
    Animal(){}
    void shout(){
        System.out.println("动物叫");
    }
}

class Cat extends Animal{
    void shout(){
        System.out.println("喵喵喵~~");
    }
}

class Dog extends Animal{
    String color;
    void shout(){
        System.out.println("汪汪汪~~");
    }
}