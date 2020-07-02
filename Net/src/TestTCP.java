import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        BufferedInputStream buffer = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream O = new BufferedOutputStream(new FileOutputStream(new File("src/cc.txt")));
        byte[] b = new byte[1024*10];
        int len =-1;
        while ((len = buffer.read(b))!=-1){
            O.write(b,0,len);
        }
        O.flush();
        O.close();
        buffer.close();
        socket.close();
        serverSocket.close();
    }
}
