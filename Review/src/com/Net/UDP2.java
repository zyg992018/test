package com.Net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDP2 {
    public static void main(String[] args) {
        Client1 c =new Client1();
        c.start();
        Server1 s = new Server1();
        s.start();

    }

}

class Server1 extends Thread{
    @Override
    public void run() {
        try {
            DatagramSocket s = new DatagramSocket(9999);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8888);
            DatagramPacket p = new DatagramPacket("asdfgfsdfdshjkl".getBytes(),0,10,inetSocketAddress);
            s.send(p);
            s.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client1 extends Thread{
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            InetSocketAddress socketAddress = new InetSocketAddress("localhost",9999);
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b,0,b.length,socketAddress);
            socket.receive(packet);
            String s = new String(packet.getData());
            System.out.println(s);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}