import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://www.baidu.com");
        URL url = new URL("http://jwgl.just.edu.cn:8080/");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3984.0 Safari/537.36 Edg/80.0.358.0");

//        InputStream is = url.openStream();
        BufferedReader b = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
        String msg = null;
        while((msg = b.readLine())!=null){
            System.out.println(msg);
        }
        b.close();
    }
}
