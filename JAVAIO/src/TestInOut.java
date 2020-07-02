import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestInOut {
    public static void main(String[] args) {
       //test01();
        //test02();
        //test03();
        //copyFile("src\\testDir\\cat.jpg","src\\testDir\\cat1.jpg");
        //test04();
        //File f = new File("src\\testdir");
        //f.mkdir();
        //copyDir("src\\testDir","src\\aa");
    }
    public static void test01(){
        FileInputStream f=null;
        try {
            f = new FileInputStream("src\\testDir\\alice.txt");
            int temp;
            while ((temp = f.read()) != -1){
                System.out.print((char)temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                f.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void test02(){
        FileInputStream f = null;
        try {
            f = new FileInputStream("src\\testDir\\alice.txt");
            byte[] temp = new byte[1024];
            int len = 0;
            while((len = f.read(temp)) != -1){
                String s = new String(temp,0,len);
                System.out.print(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                f.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void test03(){
        File f = new File("src\\testDir\\out.txt");
        FileOutputStream is = null;
        try {
            is = new FileOutputStream(f);
            int i = -1;
            String s = new String("hello! if is ig\n");
            byte[] b = s.getBytes();
            is.write(b);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void copyFile(String source,String des){
        File f1 = new File(source);
        File f2 = new File(des);
        FileInputStream S = null;
        FileOutputStream D = null;
        try {
            S = new FileInputStream(f1);
            D = new FileOutputStream(f2);
            byte[] b = new byte[1024];
            int len;
            while((len = S.read(b) )!=-1){
                D.write(b,0,len);
            }
        }catch (Exception E){
            E.printStackTrace();
        }finally {
            try{
                if(S!=null && D != null) {
                    D.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(S!=null && D != null) {
                    S.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void test04(){
        File f = new File("src\\testDir\\out.txt");
        FileOutputStream is = null;
        try{
            is = new FileOutputStream(f,true);
            String s = "Io is so easy!";
            byte[] b =s.getBytes();
            is.write(b,0,b.length);
            is.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public static void copyDir(String souDir, String desDir){
        File S = new File(souDir);
        File D = new File(desDir);
        if(S.isDirectory()){
            if(!(D.exists()))
                D.mkdir();
            for(File i : S.listFiles()){
                String path = D.getAbsolutePath()+"\\"+i.getName();
                if(i.isDirectory()){
                    copyDir(i.getAbsolutePath(),path);
                }
                else{
                    copyFile(i.getAbsolutePath(),path);
                }
            }
        }else{
            copyFile(S.getAbsolutePath(),D.getAbsolutePath());
        }
    }
}
