import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TetsPerson {
    public static void main(String[] args){
        Person p = new Person(1,"小王","男",13);
        try {
            int i = PersonDAO.insert(p);
            if(i==1)System.out.println("插入成功");
            p.setAge(15);
            i = PersonDAO.update(p);
            if(i==1)System.out.println("插入成功");
            i = PersonDAO.delete(p);
            if(i==1)System.out.println("插入成功");

            Person d = PersonDAO.select(1);
            if(d!=null)
                System.out.println(d.getName());
            List<Person> l = PersonDAO.select();
            for(Person f:l){
                System.out.println(f.getName());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
