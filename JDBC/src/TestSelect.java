import java.sql.*;

public class TestSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC",
                "root",
                "990902"
        );

        //创建状态
        Statement statement = connection.createStatement();
        //执行SQL语句
        String sql = "SELECT * FROM PERSON ORDER BY AGE DESC,ID";
        ResultSet resultSet= statement.executeQuery(sql);
        //处理结果
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            int age = resultSet.getInt(4);
            System.out.println("id:"+id+" name:"+name+" sex:"+sex+" age:"+age);
        }
        //关闭状态连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
