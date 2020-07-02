import sun.nio.ch.DatagramSocketAdaptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPUpfile {
    public static void main(String[] args) throws IOException {
        File f = new File("src/aa.txt");
        FileInputStream i = new FileInputStream(f);
        byte[] a = new byte[1024*10];

        DatagramSocket socket = new DatagramSocket(8080);
        InetSocketAddress address = new InetSocketAddress("localhost",9090);
        int len = 0;
        while ((len = i.read(a,0,a.length))!=-1){
//            System.out.println(new String(a));
            DatagramPacket packet = new DatagramPacket(a,0,len,address);
            socket.send(packet);
        }
        DatagramPacket packet = new DatagramPacket(new byte[0],0,0,address);
        socket.send(packet);
        socket.close();
        i.close();



    }
}
