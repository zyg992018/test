public class TestGeneric {
    public static void main(String[] args){
        MyCollection m = new MyCollection();
        m.set("李明",0);
        m.set(1234,1);
        String s = (String)m.get(0);
        Integer i = (Integer)m.get(1);
        System.out.println(s+i);
        MyCollection2<String> S = new MyCollection2<>();
        S.set("黎明",0);
        //S.set(1234,1);限定了类型
        String s1 = S.get(0);
        System.out.println(s1);
    }
}

class MyCollection{
    Object[] obj = new Object[5];

    public void set(Object o,int index){
        obj[index] = o;
    }

    public Object get(int index){
        return obj[index];
    }
}

class MyCollection2<E>{
    Object[] obj = new Object[5];
    public void  set(E e,int index){
        obj[index] = e;
    }
    public E get(int index){
        return (E)obj[index];
    }
}