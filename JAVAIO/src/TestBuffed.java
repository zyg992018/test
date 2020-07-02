import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.*;

public class TestBuffed {
    public static void main(String[] args){
//        testBuffedInstream();
//        copyFile("src\\testDir\\alice.txt","src\\testDir\\alice副本.txt");
//        testBuffedRider();
        copyFile2("src\\testDir\\alice.txt","src\\testDir\\alice副本.txt");
    }

    public static void testBuffedInstream(){
        File f = new File("src\\testDir\\alice.txt");
        try(BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(f));){
            int len;
            byte[] b = new byte[1024];
            while((len = buffer.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void copyFile(String source, String dest){
        File S = new File(source);
        File D = new File(dest);
        try(BufferedInputStream I = new BufferedInputStream(new FileInputStream(S));
            BufferedOutputStream O = new BufferedOutputStream(new FileOutputStream(D))){
            int len;
            byte[] temp = new byte[1024*10];
            while((len = I.read(temp)) != -1){
                O.write(temp,0,len);
                O.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void testBuffedRider(){
        File file = new File("src\\testDir\\alice.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            int len;
            String s = null;
            while((s = reader.readLine()) != null){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void copyFile2(String source,String dest){
        File S = new File(source);
        File D = new File(dest);
        try(
                BufferedReader I = new BufferedReader(new FileReader(S));
                BufferedWriter O = new BufferedWriter(new FileWriter(D))
                ){
            String s;
            while(( s = I.readLine())!=null){
                O.write(s+"\n");
                O.flush();
            }
        }
        catch (Exception e){e.printStackTrace();}
    }
}
