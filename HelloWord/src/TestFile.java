import java.io.File;
public class TestFile {
    public static void main(String[] args){
//        test01();
//        test02();
        File f = new File("F:\\PhpStorm 2019.1.3");
        printDirTrees(f);
    }

    public static void test01(){
        File f = new File("../");
        System.out.println(f.getAbsoluteFile());//输出绝对路径
        System.out.println(f.getAbsolutePath());
        System.out.println(f.isFile());
        File g = new File("E:\\JAVA\\HelloWord\\src\\aa.txt");
        System.out.println(g.isFile());
        System.out.println(f.isDirectory());
        System.out.println(g.lastModified());
        System.out.println(g.getName());
        System.out.println(g.getAbsolutePath());
        System.out.println(g.length());
    }
    public static void test02(){
        File f = new File("E:\\JAVA\\HelloWord\\src\\file\\file");
//        boolean flag = f.mkdir();//没有文件不创建整个目录树,如果只有一层则直接创建
        boolean flag = f.mkdirs();//直接创建目录树
    }
    public static void printDirTrees(File file){
        printDirTrees(file,0);
    }
    //打印目录树
    private static void printDirTrees(File file,int deepth){
        for(int i = 0; i < deepth-1; i++)
            System.out.print("\t");
        System.out.print(" |\n");
        for(int i = 0; i < deepth-1; i++)
            System.out.print("\t");
        System.out.print(" --");
        System.out.print(file.getName()+"\n");
        if(file.isFile())return;
        for(File j : file.listFiles()){
            printDirTrees(j,deepth+1);
        }

    }
}
