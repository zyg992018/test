public class TestStaticProxy {
    public static void main(String[] args){
        WeddingCompany a = new WeddingCompany(new You("张飒"));
        a.happyMarry();
    }

}

interface Marry{
    void happyMarry();
}

class You implements Marry{
    String name;
    public You(String n){
        name = n;
    }
    @Override
    public void happyMarry() {
        System.out.println(name+"和嫦娥结婚了");
    }
}

//代理
class WeddingCompany implements Marry{
    private You y;//真实角色
    public WeddingCompany(You you){
        y = you;
    }
    public void setY(You y) {
        this.y = y;
    }

    public You getY() {
        return y;
    }

    @Override
    public void happyMarry() {
           ready();
           y.happyMarry();
           after();
    }
    public void ready(){
        System.out.println(y.name+"的婚礼准备");
    }
    public void after(){
        System.out.println(y.name+"的婚礼结束");
    }
}