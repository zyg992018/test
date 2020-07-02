import sun.awt.image.ImageDecoder;
import sun.awt.image.InputStreamImageSource;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestInputOutputStreamRiderWriter {
    public static void main(String [] args){
//        testInputOutReaderWriter();
//        testURL();
//        downloadGif("http://www.baidu.com/img/gs.gif");
//        downloadGif("http://www.baidu.com");
        downloadGif("http://www.hao123.com");
        downloadGif("http://www.baidu.com/img/bd_logo1.png");
    }
    public static void testInputOutReaderWriter(){
        InputStreamReader I= new InputStreamReader(System.in);
        OutputStreamWriter O = new OutputStreamWriter(System.out);
        try{
            char[] c = new char[20];
            int len;
            while ((len = I.read(c))!=-1){
                String s =new String(c,0,len);
                if(s.equals("exit\n"))break;
                O.write(s);
                O.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                I.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                O.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void testURL(){
        try {
            URL Url = new URL("http://www.baidu.com");
            InputStreamReader I = new InputStreamReader(Url.openStream());
            char[] c = new char[1024*10];
            int len;
            while((len = I.read(c))!=-1){
                String s = new String(c,0,c.length);
                System.out.println(s);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void downloadGif(String url){
        try {
            URL Url = new URL(url);
            InputStream i = Url.openStream();
            int len;
            String [] a = url.split("/");
//            System.out.println(a[a.length-1]);
            File f = new File("src\\testDir\\"+a[a.length-1]);
            FileOutputStream Image = new FileOutputStream(f);
            byte[] b = new byte[1024];
            while((len = i.read(b))!=-1){
                    Image.write(b,0,len);
            }
            Image.close();
            i.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
