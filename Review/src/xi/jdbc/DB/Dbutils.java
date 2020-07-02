package xi.jdbc.DB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Dbutils {
    private static Properties properties = new Properties();
    public static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
    static{
        InputStream inputStream = Dbutils.class.getResourceAsStream("./db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void begin() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }
    public static void commit() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
        closeAll(connection,null,null);
    }
    public static void rollback() throws SQLException {
        Connection connection = getConnection();
        connection.rollback();
        closeAll(connection,null,null);
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = THREAD_LOCAL.get();
        if(connection==null){
            connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),
                    properties.getProperty("password"));
            THREAD_LOCAL.set(connection);
        }
        return connection;
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
                THREAD_LOCAL.remove();//移除connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
