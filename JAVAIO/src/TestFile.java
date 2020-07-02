import java.io.File;

public class TestFile {
    public static void main(String[] args){
        File f = new File("E:\\JAVA\\JAVAIO\\src\\testDir");
        File f1 = new File("src\\testDir");
        System.out.println(f.getName());
        System.out.println(f.getPath());//绝对路径显示绝对路径名称
        System.out.println(f1.getPath());//相对路径显示相对路径名称,相对于项目
        System.out.println(f1.exists());
        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.equals(f));
        System.out.println(f.getParent());
        System.out.println(f.toPath());
        System.out.println(f.toString());
        System.out.println(f.isDirectory());
        System.out.println(f.length());
        File n = new File("E:\\JAVA\\JAVAIO\\src\\testDir\\aa");
        System.out.println(n.mkdir());
        for(String i : f.list()){
            System.out.println(i);
        }
        for(File j : f.listFiles()){
            System.out.println(j.length());
        }
    }
}
