import java.io.*;

public class TestByteInOutput {
    public static void main(String[] args){
//        test01();
//        test02();
//        sw("src\\testDir\\alice.txt","src\\testDir\\alice1.txt");
    }
    public static void test01(){
        ByteArrayOutputStream O = new ByteArrayOutputStream();
        String s = "你好吗?";
        try{
            O.write(s.getBytes());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(O.toString());
    }
    public static void test02(){
        String s = "我们的世界";
        byte[] bb = s.getBytes();
        ByteArrayInputStream b = new ByteArrayInputStream(bb,0,bb.length);
        byte[] d = new byte[20];
        try{
            int len = b.read(d);
            String ss = new String(d,0,len);
            System.out.println(ss);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void sw(String s,String d){
        File S = new File(s);
        File D = new File(d);
        if(S.isFile()) {
            ByteArrayOutputStream O = new ByteArrayOutputStream();
            FileInputStream f = null;
            try {
                f = new FileInputStream(S);
                int len;
                byte[] b = new byte[1024];
                while ((len = f.read(b))!=-1){
                    O.write(b,0,len);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    f.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream file = null;
            try{
                file = new FileOutputStream(D);
                file.write(O.toByteArray(),0,O.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    file.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
