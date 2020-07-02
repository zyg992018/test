import java.lang.reflect.InvocationTargetException;

public class reflect {
    private static Object Iphone;

    public static void main(String[] args){
        Iphone iphone = new Iphone();
        Class p = iphone.getClass();
        p = Iphone.class;
        try {
            p = Class.forName("Iphone");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Iphone i = (Iphone) p.newInstance();
            i  = (Iphone)p.getConstructor().newInstance();
            System.out.println(i);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


class Iphone{

}