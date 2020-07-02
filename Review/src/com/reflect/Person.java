package com.reflect;

public class Person {
    private String name = null;
    private int age     ;
    public Person(){count++;}
    private static int count = 0;
    public Person(String name, int age) {
        count++;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    private void eat(){
        System.out.println("吃吃吃");
    }
    public static void Count(){
        System.out.println(count);
    }
}
