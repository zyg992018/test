import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPThreadClient {
    public static void main(String[] args) throws InterruptedException {
        Receive2 r =  new Receive2();
        Send1 s =  new Send1("你好嘢！");
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(s);
        t1.start();
        Thread.sleep(10000);
        t2.start();
    }
}


class Send1 implements Runnable{
    String msg = null;
    public Send1(String msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(6060);

            byte[] b = msg.getBytes("UTF-8");
            DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                    new InetSocketAddress("localhost",7070));
            socket.send(packet);
            socket.close();
        } catch (SocketException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Receive2 implements Runnable{
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] b = new byte[1024*100];
            DatagramPacket packet = new DatagramPacket(b,0,b.length,
                    new InetSocketAddress("localhost",8080));
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}