import java.sql.*;

public class TestLogin {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection collection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC",
                "root",
                "990902"
        );
        Statement statement = collection.createStatement();

//        createUser(statement);

//        insert(statement);
        boolean flag =  login(statement, "小红","12345");
        if(flag)System.out.println("登录成功");
        else System.out.println("登陆失败");
        flag = login2(collection,"小红" ,"12345");
        if(flag)System.out.println("登录成功");
        else System.out.println("登陆失败");
        flag =  login(statement, "abc' OR 1=1; #","12345");
        if(flag)System.out.println("登录成功");
        else System.out.println("登陆失败");
        //防止SQL注入 preparedStatement
        flag = login2(collection,"abc' OR 1=1; #" ,"12345");
        if(flag)System.out.println("登录成功");
        else System.out.println("登陆失败");
        statement.close();
        collection.close();
    }
    public static void createUser(Statement statement) throws SQLException {
        String sql = "Create TABLE User(id int primary key auto_increment,username varchar(20) not null ," +
                "password varchar(20) not null,phone varchar(11))";
        boolean flag = statement.execute(sql);
        if(flag)System.out.println("创建成功");
    }
    public static void insert(Statement statement) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("Insert into User(username, password, phone) values('张三','12345','42432423423')");
        statement.executeUpdate(sql.toString());
        sql.delete(0,sql.length());
        sql.append("Insert into User(username, password, phone) values('李四','12345','42432445433')");
        statement.executeUpdate(sql.toString());
        sql.delete(0,sql.length());
        sql.append("Insert into User(username, password, phone) values('王二','12345','42432423443')");
        statement.executeUpdate(sql.toString());
        sql.delete(0,sql.length());
        sql.append("Insert into User(username, password, phone) values('小红','12345','42432429098')");
        statement.executeUpdate(sql.toString());
        sql.delete(0,sql.length());
    }
    public static boolean login(Statement statement,String username,String password) throws SQLException {
//        String sql = "SELECT username,password FROM USER";
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            String _username = resultSet.getString("username");
//            if(!username.equals(_username))continue;
//            String _password = resultSet.getString("password");
//            if(!password.equals(_password))continue;
//            else return true;
//        }
//        return false;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER WHERE USERNAME = '"+username+"' and password = '"+ password +"'");
        if(resultSet.next())return true;
        else return  false;
    }
    public static boolean login2(Connection connection,String username,String password) throws SQLException {
        PreparedStatement preparedStatement =  connection.prepareStatement("SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())return true;
        return false;
    }
}
