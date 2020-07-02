package com.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class JavaUDPChat {
    public static void main(String[] args) {
        Thread t = new Thread(new Send(9999,9900,"localhost"));
        Thread t2 = new Thread(new Receive(9900,9999,"localhost"));
        t2.start();
        t.start();
    }
}

class Send implements Runnable{
    int SrcPort;
    int DesPort;
    String Ip;

    public Send(int srcPort, int desPort, String ip) {
        SrcPort = srcPort;
        DesPort = desPort;
        Ip = ip;
    }

    @Override
    public void run() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(Ip,DesPort);
        try {
            DatagramSocket socket = new DatagramSocket(SrcPort);
            String info = "";
            while (!info.equals("bye")){
                System.out.println(info+"------------");
                Scanner s = new Scanner(System.in);
                info = s.next();
                DatagramPacket packet = new DatagramPacket(info.getBytes(),0,info.getBytes().length,inetSocketAddress);
                socket.send(packet);
                s.close();
                System.out.println(info+"********bye");
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receive implements Runnable{
    int SrcPort;
    int DesPort;
    String Ip;

    public Receive(int srcPort, int desPort, String ip) {
        SrcPort = srcPort;
        DesPort = desPort;
        Ip = ip;
    }

    @Override
    public void run() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(Ip,DesPort);
        try {
            DatagramSocket socket = new DatagramSocket(SrcPort);
            String s = new String("");
            while (!(s.equals("bye"))){
                byte[] b= new byte[1024];
                DatagramPacket packet = new DatagramPacket(b,0,b.length,inetSocketAddress);
                socket.receive(packet);
                s = new String(b,0,packet.getLength());
                System.out.println(s);
            }
            socket.close();
            run();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
