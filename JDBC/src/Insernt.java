import java.sql.*;

public class Insernt {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC",
                    "root","990902"
                )        ;
        Statement  statement= connection.createStatement();
        int s = statement.executeUpdate("INSERT INTO PERSON VALUES(id='1',name='小丽',sex='女',age='12')");
        System.out.println(s);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person(id,name,sex,age) VALUES (?,?,?,?)");
        preparedStatement.setInt(1,12);
        preparedStatement.setString(2,"你好");
        preparedStatement.setString(3,"女");
        preparedStatement.setInt(4, 13);
        int flag =  preparedStatement.executeUpdate();
        System.out.println(flag);
    }

}
