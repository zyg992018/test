package zyg.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
    private static Properties properties = new Properties();
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
    private static DruidDataSource druidDataSource = null;
    static{
        InputStream inputStream = DbUtils.class.getResourceAsStream("./db.properties");
        try {
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get();
        if(connection==null){
            try {
                connection=druidDataSource.getConnection();
                THREAD_LOCAL.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
    public static void begin(){
        Connection connection = null;
        connection=getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void commit(){
        Connection connection = null;
        connection = getConnection();
        try {
            connection.commit();
            THREAD_LOCAL.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    public static void rollback(){
        Connection connection = null;
        connection = getConnection();
        try {
            connection.rollback();
            THREAD_LOCAL.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
