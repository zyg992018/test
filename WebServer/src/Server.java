import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class Server {
    ServerSocket server;
    Socket socket;
    public static void main(String[] args){
        Server s = new Server();
        s.start();
        s.receive();

    }
    public void start(){
        try {
            server = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void receive(){
        try {
            while (true) {
                socket = server.accept();
                InputStream io = socket.getInputStream();
                byte[] b = new byte[1024 * 1000];
                int len = io.read(b);
                String info = new String(b, 0, len);
                System.out.println(info);

                StringBuilder res = new StringBuilder();
                StringBuilder content = new StringBuilder();
                content.append("<!doctype html>");
                content.append("<html>");
                content.append("<head>");
                content.append("<title>请求成功");
                content.append("</title><meta charset=\"utf-8\">");
                content.append("</head>");
                content.append("<body>请求成功");
                content.append("</body>");
                content.append("</html>");
                String CRF = "\r\n";
                int size = content.toString().getBytes().length;
                res.append("HTTP/1.1").append(" ");
                res.append(200).append(" ");
                res.append("OK").append(CRF);
                res.append("Date:").append(new Date(System.currentTimeMillis())).append(CRF);
                res.append("Server:").append("server1.1.1;charset=UTF-8").append(CRF);
                res.append("Content-type:text/html").append(CRF);
                res.append("Content-length:").append(size).append(CRF);
                res.append(CRF).append(content.toString());
                BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                buffer.write(res.toString());
                buffer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop(){
        try {
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
