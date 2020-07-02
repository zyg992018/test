import java.net.InetSocketAddress;

public class TestPort {
    public static void main(String[] args){
        InetSocketAddress socketAddress = new InetSocketAddress("36.152.44.96",443);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",80);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getHostName());
        System.out.println(socketAddress1.getPort());
    }
}
