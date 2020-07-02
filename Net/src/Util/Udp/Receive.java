package Util.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Receive extends Thread{
    int SrcPort;
    int desPort;

    public Receive(int SrcPort,int desPort){
        this.SrcPort = SrcPort;
        this.desPort = desPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(SrcPort);
            while (1==1) {
                byte[] b = new byte[1024];
                DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                        new InetSocketAddress("localhost", desPort));
                socket.receive(packet);
                String s = new String(packet.getData(),0,packet.getLength());
                System.out.println(s);
                if("bye".equals(s)) {
                    break;
                }
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
