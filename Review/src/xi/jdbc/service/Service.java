package xi.jdbc.service;

import xi.jdbc.Entrty.Person;
import xi.jdbc.DB.Dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    public static boolean getMoney(Person person,String password,int money) throws SQLException {
        Connection connection =  Dbutils.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM banCount WHERE username=? AND password=?");
        preparedStatement1.setString(1,person.getName());
        preparedStatement1.setString(2,password);
        ResultSet resultSet = preparedStatement1.executeQuery();
        int flag = 0;
        if(resultSet.next()){
            int m = resultSet.getInt("money");
            if(m>=money){
                m-=money;
                PreparedStatement preparedStatement = connection.prepareStatement("Update banCount set money=? WHERE username=? AND password=?");
                preparedStatement.setInt(1,m);
                preparedStatement.setString(2,person.getName());
                preparedStatement.setString(3,password);
                flag = preparedStatement.executeUpdate();
                System.out.println(person.getName()+"成功取到"+money+"元");
            }
        }
        return flag == 1;
    }
    public static boolean putMoney(Person person,String password,int money) throws SQLException {
        Connection connection =  Dbutils.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM banCount WHERE username=? AND password=?");
        preparedStatement1.setString(1,person.getName());
        preparedStatement1.setString(2,password);
        ResultSet resultSet = preparedStatement1.executeQuery();
        int flag = 0;
        if(resultSet.next()){
            int m = resultSet.getInt("money");
            m+=money;
            PreparedStatement preparedStatement = connection.prepareStatement("Update banCount set money=? WHERE username=? AND password=?");
            preparedStatement.setInt(1,m);
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,password);
            flag = preparedStatement.executeUpdate();
            System.out.println(person.getName()+"成功存入"+money+"元");
        }
        return flag == 1;
    }
}
