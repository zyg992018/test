package com.reflect;


import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
//        text01();
//        text02();
//        Properties properties = new Properties();
//
//        Object obj = test03(properties,"setProperty",new Class[]{String.class,String.class},"倪明","12");
//        System.out.println(properties.toString());
        test04();
    }
    public static void text01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.reflect.Person");
        System.out.println(class1.getName());
        System.out.println(class1.toString());
        System.out.println(class1.getConstructor());
        Person p = (Person)class1.newInstance();
        p.setName("小明");
        p.setAge(13);
        System.out.println(p);
        Constructor<?> con = class1.getConstructor(String.class,int.class);
        Person p3 = (Person)con.newInstance("夏红",90);
        System.out.println(p3);
        Field f[]  = class1.getFields();
        for(Field ff: f){
            System.out.println(ff);
        }

    }

    public static void text02() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class02 = Class.forName("com.reflect.Person");
        Method d[] = class02.getMethods();
        for(Method m:d){
            System.out.println(m.getName());
        }
        Person p2 = (Person)class02.newInstance();
        Method m1 =  class02.getMethod("setAge", int.class);
        m1.invoke(p2,12);
        Method m2 = class02.getMethod("setName", String.class);
        m2.invoke(p2,"given");
        Method m3 = class02.getMethod("toString");
        m3.invoke(p2);
        Method d2[] = class02.getDeclaredMethods();
        for(Method m:d2){
            System.out.println(m);
        }
        Method m4 = class02.getDeclaredMethod("eat");
        m4.setAccessible(true);
        m4.invoke(p2);
        Method m5 = class02.getDeclaredMethod("Count");
        m5.invoke(null);
    }

    public static Object  test03(Object obj,String method,Class<?>[] types,Object...args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = obj.getClass();
        Method m=c.getMethod(method,types);
        return m.invoke(obj,args);
    }

    public static void test04() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.reflect.Person");
        Field f[] = class1.getFields();
        for(Field ff:f){
            System.out.println(ff.getName());
        }
        Field f1[] =class1.getDeclaredFields();
        for(Field ff: f1){
            System.out.println(ff.getName());
        }
        Object obj = class1.newInstance();
        Field f2 = class1.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(obj,12);
        Field f3 = class1.getDeclaredField("name");
        f3.setAccessible(true);
        f3.set(obj,"李丽");
        System.out.println(f3.get(obj));
        System.out.println(class1.getMethod("toString").invoke(obj));
    }

}
