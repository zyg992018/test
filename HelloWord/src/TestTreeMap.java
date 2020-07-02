import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args){
        test01();
        test02();
    }
    public static void test01(){
        TreeMap<Integer,String> treemap1 = new TreeMap<>();
        treemap1.put(1,"lixia");
        treemap1.put(2,"xiaohong");
        treemap1.put(4,"xiaoli");
        treemap1.put(3,"xiaoming");
        for(Integer i : treemap1.keySet()){
            System.out.println(i);
        }
    }

    public static void test02(){
        TreeMap<Emp,String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(150,"小李",3000),"工作不努力");
        treemap2.put(new Emp(120,"小红",5000),"工作努力");
        treemap2.put(new Emp(140,"小明",4000),"工作一般");
        treemap2.put(new Emp(130,"小明",4000),"工作一般");
        for(Emp i : treemap2.keySet()){
            System.out.println(i.salary+i.name);
        }
    }

}

class Emp implements Comparable<Emp>{
    int id;
    String name;
    int salary;
    public Emp(){}
    public Emp(int _id,String _name,int _salary){
        id = _id;
        name = _name;
        salary = _salary;
    }

    @Override
    public int compareTo(Emp o) {
        if(salary>o.salary)return 1;
        else if(salary<o.salary)return -1;
        else if(id>o.id)return 1;
        else if(id<o.id)return -1;
        return 0;
    }
}
