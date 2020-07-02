package com.Net;

import com.sun.xml.internal.fastinfoset.sax.Features;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UDP {
    public static void main(String[] args) throws IOException, InterruptedException {
        UDPClient udpClient = new UDPClient();
        UDPServer udpServer = new UDPServer();
        FutureTask<Integer> task = new FutureTask<>(udpClient);
        FutureTask<Integer> task2 = new FutureTask<>(udpServer);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task2);
        t1.start();
//        Thread.sleep(3000);
        t2.start();
    }
}

class UDPServer implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8800);
        DatagramSocket socket = new DatagramSocket(9900);
        DatagramPacket packet = new DatagramPacket("adsadads".getBytes(),0,10,inetSocketAddress);
        System.out.println(222222222);
        socket.send(packet);
        socket.close();
        return 1;
    }
}

class UDPClient implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",9900);
        DatagramSocket socket = new DatagramSocket(8800);
        byte[] b =new byte[1024];
        DatagramPacket packet = new DatagramPacket(b,0,b.length,inetSocketAddress);
        System.out.println(111111);
        socket.receive(packet);
        String s = new String(packet.getData());
        System.out.println(s);
        socket.close();
        return 1;
    }
}