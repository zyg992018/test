import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class TestRiderWriter {
    public static void main(String[] args){
        test01();
    }
    public static void test01() {
        File f = new File("src\\testDir\\我们的世界.txt");
        Writer w = null;
        try {
            w = new FileWriter(f);
            w.write("地球是我们的世界。\n");
            w.append("我们的世界是美好的!\n");
        }catch (Exception E){
            E.printStackTrace();
        }finally {
            try {
                w.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        FileReader r = null;
        try {
            r = new FileReader(f);
            char[] s = new char[1024];
            int len;
            while((len = r.read(s)) != -1){
                String S = new String(s,0,len);
                System.out.println(S);
            }
        }catch (Exception E){
            E.printStackTrace();
        }finally {
            try {
                w.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
