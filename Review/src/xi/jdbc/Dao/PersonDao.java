package xi.jdbc.Dao;

import xi.jdbc.DB.Dbutils;
import xi.jdbc.Entrty.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public static Person select(String username) throws SQLException {
        Person person = null;
        Connection connection =  Dbutils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM Person WHERE name=?");
        preparedStatement.setString(1,username);
        ResultSet res = preparedStatement.executeQuery();
        if(res.next()){
            person = new Person(res.getString("name"),res.getString("sex"),res.getInt("age"));
        }
        Dbutils.closeAll(connection,preparedStatement,res);
        return person;
    }
    public static List<Person> selectAll(String username) throws SQLException {
        List<Person> list = new ArrayList<>();
        Connection connection =  Dbutils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM Person");
        ResultSet res = preparedStatement.executeQuery();
        if(res.next()){
            Person person = new Person(res.getString("name"),res.getString("sex"),res.getInt("age"));
            list.add(person);
        }
        Dbutils.closeAll(connection,preparedStatement,res);
        return list;
    }
}
