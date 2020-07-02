import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Dictionary;

public class TestDataStream {
    public static void main(String[] args){
//        test01();
        test02();
    }

    public static void test01(){
        ByteArrayOutputStream B = new ByteArrayOutputStream();
        DataOutputStream d = new DataOutputStream(B);
        try {
            d.writeChar('d');
            d.writeInt(12);
            d.writeUTF("dadada");
            DataInputStream d2 = new DataInputStream(new ByteArrayInputStream(B.toByteArray()));
            char a = d2.readChar();
            int b = d2.readInt();
            String s = d2.readUTF();
            System.out.println(a+b+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void test02(){
        ByteArrayOutputStream O = new ByteArrayOutputStream();
        try {
            ObjectOutputStream o = new ObjectOutputStream(O);
            Emplee e= new Emplee("张三",15000);
            o.writeObject(e);
            ObjectInputStream I = new ObjectInputStream(new ByteArrayInputStream(O.toByteArray()));
            Emplee ee =(Emplee)I.readObject();
            System.out.println(ee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Emplee implements Serializable{
    String name;
    int s;
    public String toString(){
        return name+"->"+s;
    }
    public Emplee(){}
    public Emplee(String _name,int _s){
        name=_name;
        s=_s;
    }
}
