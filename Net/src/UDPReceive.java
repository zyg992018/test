import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        File f = new File("src/bb.txt");
        FileOutputStream O = new FileOutputStream(f);

        DatagramSocket socket = new DatagramSocket(9090);
        InetSocketAddress address = new InetSocketAddress("localhost",8080);
        byte[] b = new byte[10*1024];
        int len = 0;
        do{
            DatagramPacket packet = new DatagramPacket(b,0,b.length,address);
            socket.receive(packet);
            len = packet.getLength();
            O.write(packet.getData(),0,packet.getLength());
        }while (len!=0);
        O.close();
        socket.close();

    }


}
