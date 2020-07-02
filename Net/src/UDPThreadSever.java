import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class UDPThreadSever {
    public static void main(String[] args) throws InterruptedException {
        Receive1 r =  new Receive1();
        Send2 s =  new Send2("你好嘢！");
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(s);
        t1.start();
        Thread.sleep(10000);
        t2.start();
    }
}

 class Send2 implements Runnable{
    String msg = null;
    public Send2(String msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(8080);

            byte[] b = msg.getBytes("UTF-8");
            DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                    new InetSocketAddress("localhost",9090));
            socket.send(packet);
            socket.close();
        } catch (SocketException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 }

 class Receive1 implements Runnable{
     @Override
     public void run() {
         try {
             DatagramSocket socket = new DatagramSocket(7070);
             byte[] b = new byte[1024*100];
             DatagramPacket packet = new DatagramPacket(b,0,b.length,
                     new InetSocketAddress("localhost",6060));
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