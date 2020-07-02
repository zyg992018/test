import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TestUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(8888);
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(data));
        out.writeObject(new Integer(12));
        out.writeObject(new Float(12.89));
        out.writeObject(new StringBuffer("dadafaf"));
        DatagramPacket packet = new DatagramPacket(data.toByteArray(),0,data.size(),
                new InetSocketAddress("localhost",8080));
        client.send(packet);
        client.close();
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(new byte[1000])));
    }
}
