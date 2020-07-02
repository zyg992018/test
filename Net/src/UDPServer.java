import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        test01();
    }
    public static void test01() throws IOException {
//        byte[] b = new byte[100*1024];
        ByteOutputStream b2 = new ByteOutputStream();
        ObjectOutputStream O = new ObjectOutputStream(b2);
//        O.writeObject(new Integer(10));
        O.writeObject(new Float(10.11));
        O.writeObject("you");

        DatagramSocket socket= new DatagramSocket(8080);
        DatagramPacket packet = new DatagramPacket(b2.getBytes(),0,b2.size(),
                new InetSocketAddress("localhost",9999));
        socket.send(packet);
        socket.close();

    }
}
