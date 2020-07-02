import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException {
    public static void main(String[] args) {
        int a = 10;
        try {
            FileReader reader = new FileReader("E:\\JAVA\\HelloWord\\src\\aa.txt");
            char s = (char) reader.read();
            System.out.println(reader.getEncoding());
            System.out.println(s);
            reader.close();
            if(a <= 10)throw new IllegalException("不合法错误");
        } catch (FileNotFoundException e) {//FileNotFoundException继承IOException要写在前面
//            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("读写出错");
        }
        catch(IllegalException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("aaa");
        }
    }
}

class IllegalException extends RuntimeException{
    public IllegalException(){}
    public IllegalException(String msg){super(msg);}
}
