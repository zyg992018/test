package com.io;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class javaObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        test01();
    }
    public static void test01() throws IOException, ClassNotFoundException {
        //使用文件存储
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/object.txt"));
        FileInputStream fileInputStream = new FileInputStream(new File("src/object.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //写入数据
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        dataOutputStream.writeUTF("你好\n");
        dataOutputStream.writeInt(12);
        dataOutputStream.writeChar('d');
        dataOutputStream.writeDouble(12.23);
        dataOutputStream.flush();
        //读取数据
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        String s = dataInputStream.readUTF();
        Integer a = dataInputStream.readInt();
        char c = dataInputStream.readChar();
        float f = dataInputStream.readFloat();
        System.out.println(s+a+c+f);
        fileInputStream.close();
        fileOutputStream.close();
        //使用字节存储
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //需要一个文件输出流或者是byteArray输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeChar('a');
        objectOutputStream.writeInt(12);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(System.currentTimeMillis()));
        objectOutputStream.writeObject(new Person("你好",12,calendar));
        //需要一个文件输入流或者是byteArray输入流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        char c1 = objectInputStream.readChar();
        int b = objectInputStream.readInt();
        Person p = (Person) objectInputStream.readObject();
        System.out.println(p);
    }


}

class Person implements Serializable{
    String name;
    int age;
    Calendar birth;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public Person(String name, int age, Calendar birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;

    }
}