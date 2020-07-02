import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetSocketAddress;



public class TestUDP2 {
    public static void main(String[] args) throws IOException {
//        DatagramSocket client = new DatagramSocket(8080);
////        byte[] data = new byte[100];
//
//        byte[] datas = new byte[100*1024];
//        ByteArrayInputStream data = new ByteArrayInputStream(datas);
//        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(new byte[1000])));
        ByteArrayOutputStream O = new ByteArrayOutputStream();
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(O.toByteArray()));
//        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
//                new InetSocketAddress("localhost",8888));
//        client.receive(packet);
//
//        System.out.println(in.readInt());
//        System.out.println(in.readFloat());
//        System.out.println(in.readUTF());
//        System.out.println(new String(datas,0,packet.getLength()));
//        client.close();
    }
}
