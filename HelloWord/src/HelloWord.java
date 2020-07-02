/***
 * java基础
 */

import java.math.*;
public class HelloWord {
    int a ;
    static int aa;
    public static void main(String[] args){
        final String name = "张永刚";
        int num1 =15;
        int num2 = 015;
        int num3 = 0x15;
        int num4 = 0b1101;
        byte num5 = 127;
        short num6 = 1234;
        long num7 = 1234567895435L;//long整形加L
        //name = "李明"; final 常量
        System.out.println(aa+name);
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
        float a = 0.1f;//float 后面加F
        double b = 0.1d;//double 后面加D
        System.out.println(a + " " + b + "  " + (a==b));
        BigDecimal bd = BigDecimal.valueOf(0.1); //浮点型不精确，精准比较要用BigDecimal
        BigDecimal bc = BigDecimal.valueOf(1.0/10);
        System.out.println(bd.equals(bc));
        System.out.println('\u0000'+""+'\uffff');//字符从\u0000到\uFFFF共65535个
        System.out.println('\u4E00' + ""+'\u9FA5');//基本汉字\u4E00-\u9FA5
        //System.out.println(0==false); 0只能表示整型不能表示boolean
        float f = 1.2F;//float f = 1.2; //小数默认为double类型
        //int i = 1 +1.2;//不能将范围大的数赋值给范围小的类型
        //System.out.println(((2>3)&(1>3/0)));&和|与&&和||都相同但&与|两边都会计算，^异或
        
    }
}
