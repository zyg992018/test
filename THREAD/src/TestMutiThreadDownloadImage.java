import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestMutiThreadDownloadImage {
    public static void main(String[] args){
        System.out.print("开始下载");
        DownloadThread t1 = new DownloadThread("https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00798-2410.jpg","1.jpg");
        DownloadThread t2 = new DownloadThread("http://img4.imgtn.bdimg.com/it/u=316958040,778721326&fm=15&gp=0.jpg","2.jpg");
        DownloadThread t3 = new DownloadThread("http://img4.imgtn.bdimg.com/it/u=2065338355,3844329913&fm=26&gp=0.jpg","3.jpg");
        DownloadThread t4 = new DownloadThread("http://img3.imgtn.bdimg.com/it/u=4217185073,86893502&fm=26&gp=0.jpg","4.jpg");
        DownloadThread t5 = new DownloadThread("http://img5.imgtn.bdimg.com/it/u=3006962646,3065581815&fm=15&gp=0.jpg","5.jpg");
        DownloadThread t7 = new DownloadThread("http://img4.imgtn.bdimg.com/it/u=2214809246,4113865626&fm=15&gp=0.jpg","6.jpg");
        DownloadThread t8 = new DownloadThread("http://img4.imgtn.bdimg.com/it/u=1367418939,3992902469&fm=26&gp=0.jpg","7.jpg");
        DownloadThread t9 = new DownloadThread("http://img1.imgtn.bdimg.com/it/u=3326674449,384951682&fm=26&gp=0.jpg","8.jpg");
        DownloadThread t10 = new DownloadThread("http://img4.imgtn.bdimg.com/it/u=2211946933,3910548619&fm=26&gp=0.jpg","9.jpg");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
class DownloadImage{
    public DownloadImage(String url,String path)  {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(path));
            System.out.println(path+"下载完成");
        } catch (IOException e) {
            System.out.println(path+"下载出错");
        }
    }
}
class DownloadThread extends Thread{
    String url;
    String name;
    public void run(){
        System.out.println(name+"开始下载");
        DownloadImage d = new DownloadImage(url,"src\\image\\"+name);
    }
    public DownloadThread(String _url,String _name){
        url = _url;
        name = _name;
    }
}
