import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class TestTCP2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        FileInputStream f = new FileInputStream(new File("src/aa.txt"));
        int len = -1;
        BufferedOutputStream I = new BufferedOutputStream(socket.getOutputStream());
        byte[] b = new byte[1024*10];
        while ((len = f.read(b))!=-1){
            I.write(b,0,len);
        }
        I.close();
        f.close();
        socket.close();
    }
}
