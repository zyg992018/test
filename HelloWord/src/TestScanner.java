import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的爱好：");
        String favor = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.println("你是"+name+",你喜欢"+favor+",你今年"+age+"岁了");
    }

}
