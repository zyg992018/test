/**
 * 测试package
 */
//导入User包的方法
import cn.sxt.oo.*;

import cn.sxt.oo.TestClass;
import cn.sxt.oo.User;

public class TextPaackage {
    public static void main(String[] args){
        User u;//导入包
        cn.sxt.oo.User U;//未导入包要带上包名
        TestClass T = new TestClass();
        //T.e = 20; 包外不能访问默认权限的属性
        T.f =20;
        //T.g = 30; 包外不能访问私有权限的属性
        //T.h = 40; 包外不能访问保护权限的属性
    }
}
