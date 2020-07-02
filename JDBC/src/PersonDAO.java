import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public static int insert(Person person) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection();
        System.out.println(person.getId()+person.getName()+person.getSex()+person.getAge());
        PreparedStatement preparedStatement =  connection.prepareStatement("INSERT INTO PERSON(id,name,sex,age) VALUES (?,? ,?,?)");
        System.out.println(person.getId()+person.getName()+person.getSex()+person.getAge()+"-----------");
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getSex());
        preparedStatement.setInt(4,person.getAge());
        int flag = preparedStatement.executeUpdate();        preparedStatement.close();

        DBUtils.close(connection,null,preparedStatement);
        return flag;
    }
    public static int update(Person person) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =  connection.prepareStatement("UPDATE  " +
                "PERSON SET name=? , sex=?, age=?  WHERE id=?");
        System.out.println(person.getId()+person.getName()+person.getSex()+person.getAge());
        preparedStatement.setString(1,person.getName());
        preparedStatement.setString(2,person.getSex());
        preparedStatement.setInt(3,person.getAge());
        preparedStatement.setInt(4,person.getId());
        int flag = preparedStatement.executeUpdate();
        DBUtils.close(connection,null,preparedStatement);
        return flag;
    }
    public static int delete(Person person) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =  connection.prepareStatement("DELETE FROM PERSON WHERE id=? ");
        preparedStatement.setInt(1,person.getId());
        int flag  = preparedStatement.executeUpdate();
        DBUtils.close(connection,null,preparedStatement);
        return flag;
    }
    public static List<Person> select() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement  = connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        Person person = null;
        if(resultSet.next()){
            person =new Person(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("sex"),resultSet.getInt("age"));
            personList.add(person);
        }
        resultSet.close();
        DBUtils.close(connection,null,preparedStatement);
        return personList;
    }
    public static   Person select(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement  = connection.prepareStatement("SELECT * FROM PERSON WHERE id=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return new Person(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("sex"),resultSet.getInt("age"));
        }
        resultSet.close();
        DBUtils.close(connection,null,preparedStatement);
        return null;
    }

}
