import java.sql.*;

public class TestConnectMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册mysql驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        String url = "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC";
        String user = "root";
        String password = "990902";

        Connection connect = DriverManager.getConnection(url,user,password);
        connect.clearWarnings();
        if(connect!=null){
            System.out.println("连接成功");
        }

        Statement state = connect.createStatement();
        String sql = "insert into person values(5,\"小丽\",'女',12)";
//        int res = state.executeUpdate(sql);
//        System.out.println(res);
        sql = "SELECT * FROM person ORDER BY age DESC ";
        ResultSet result =  state.executeQuery(sql);
        Array s = result.getArray(1);
        System.out.println(s.getArray());
        state.close();
        connect.close();
    }
}
