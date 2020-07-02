package DB;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static Properties properties = new Properties();
    private static DruidDataSource ds= null;
    private static  final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
    static{
        InputStream inputStream = DBUtils.class.getResourceAsStream("./db.properties");
        try {
            properties.load(inputStream);
            ds =(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get();
        if(connection==null) {
            try {
                connection = ds.getConnection();
                THREAD_LOCAL.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
    //
    public static void begin(){
        Connection connection = getConnection();
        if(connection!=null){
            try {
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void commit(){
        Connection connection = getConnection();
        if(connection!=null){
            try {
                connection.commit();
                connection.close();
                THREAD_LOCAL.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void rollback(){
        Connection connection = getConnection();
        if(connection!=null){
            try {
                connection.rollback();
                connection.close();
                THREAD_LOCAL.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
