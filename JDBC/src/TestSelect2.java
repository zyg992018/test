import java.sql.*;

public class TestSelect2 {
    public static void main(String[] agrs) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC",
                "root",
                "990902"
        );
        //获得状态
        Statement statement = connection.createStatement();
        //执行SQL
        String sql = "SELECT * FROM PERSON";
        ResultSet resultSet = statement.executeQuery(sql);
        //处理结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            System.out.println(id+"  "+  name+"  "+sex+"  "+age);
        }
        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
