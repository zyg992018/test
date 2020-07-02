import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCommonIO {
    public static void main(String[] args) throws IOException {
//        test02();
//        test03();
        test04();
    }
    public static void test01(){
        long len = FileUtils.sizeOf(new File("src"));
        PrintStream p = System.out;
        p.println((len));
        Collection<File> files =  FileUtils.listFiles(new File("src"), EmptyFileFilter.NOT_EMPTY,null);
        for(File i: files){
            p.println(i.getName());
        }
        files =  FileUtils.listFiles(new File("src"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for(File i: files){
            p.println(i.getName());
        }

        p.close();
    }
    public static void test02() throws IOException {
        PrintStream p = System.out;
        String res = FileUtils.readFileToString(new File("src\\testDir\\我们的世界.txt"),"UTF-8");
        p.print(res);
        byte[] b = FileUtils.readFileToByteArray(new File("src\\testDir\\我们的世界.txt"));
        p.println(b.length);
        List<String> L = FileUtils.readLines(new File("src\\testDir\\我们的世界.txt"),"UTF-8");
        for(String i: L){
            p.println(i);
        }
        LineIterator i = FileUtils.lineIterator(new File("src\\testDir\\我们的世界.txt"),"UTF-8");
        while(i.hasNext()){
            p.print(i.nextLine());
        }
        p.close();
    }
    public static void test03() throws IOException {
        FileUtils.write(new File("src\\testDir\\aa.txt"),"学习是一件伟大的事","UTF-8");
        FileUtils.writeStringToFile(new File("src\\testDir\\aa\\aa.txt"),"hello!","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("src\\testDir\\aa\\byte.txt"),"我是你".getBytes("UTF-8"),true);
        List<String> l = new ArrayList<>();
        l.add("张三");
        l.add("李四");
        l.add("王五");
        FileUtils.writeLines(new File("src\\testDir\\aa\\name.txt"),l,"\n",true);
    }
    public static void test04() throws IOException {
//        FileUtils.copyFile(new File("src\\testDir\\aa\\aa.txt"),new File("src\\testDir\\bb.txt"));
//        FileUtils.copyURLToFile(new URL("https://www.baidu.com"),new File("src\\testDir\\aa\\baidu.html"));
        String s = IOUtils.toString(new URL("https://www.baidu.com"),"UTF-8");
        System.out.print(s);
    }

}
