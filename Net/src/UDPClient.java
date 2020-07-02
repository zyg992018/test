import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        test01();
    }
    public static void test01() throws IOException {
        ByteOutputStream b2 = new ByteOutputStream();
        ObjectOutputStream O = new ObjectOutputStream(b2);
//        O.writeObject(new Integer(10));
//        O.writeObject(new Float(10.11));
//        O.writeObject(new String("you"));



        DatagramSocket socket = new DatagramSocket(9999);
        DatagramPacket packet = new DatagramPacket(b2.getBytes(),0,b2.size(),
                new InetSocketAddress("localhost",9999));
        socket.receive(packet);

        ByteArrayInputStream b = new ByteArrayInputStream(b2.getBytes());
        ObjectInputStream OQ = new ObjectInputStream(b);

        System.out.println(new String(packet.getData()));
        System.out.println(b2.getBytes().equals(packet.getData()));
//        System.out.println(OQ.readInt());
        System.out.println(OQ.readFloat());
        System.out.println(OQ.readUTF());
        socket.close();
    }
}

