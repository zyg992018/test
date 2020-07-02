package com.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JAVATCP {
    public static void main(String[] args) {
        new Thread(new Server(8888)).start();
        new Thread(new Client("localhost",8888)).start();
    }

}

class Client implements Runnable{
    String ip;
    int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(ip,port);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("src/aa.txt")));
            int len = -1;
            byte[] info = new byte[1024*10];
            OutputStream w = socket.getOutputStream();
            while ((len=bufferedInputStream.read(info))!=-1){
                w.write(info,0,len);
            }
            w.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server implements Runnable{
    int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src/gg.txt")));
            byte[] b = new byte[1024*10];
            int len =-1;
            while ((len=inputStream.read(b,0,b.length))!=-1){
                bufferedOutputStream.write(b,0,len);
                bufferedOutputStream.flush();
            }
            bufferedOutputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
