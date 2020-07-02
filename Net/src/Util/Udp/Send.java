package Util.Udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Send extends Thread{
    int SrcPort;
    int desPort;
    BufferedReader b;

    public Send(int SrcPort,int desPort){
        this.SrcPort = SrcPort;
        this.desPort = desPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(SrcPort);
            b = new BufferedReader(new InputStreamReader(System.in));
            while (1==1) {
                String msg = b.readLine();
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,
                        new InetSocketAddress("localhost", desPort));
                socket.send(packet);
                if(msg.equals("bye"))break;;
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
