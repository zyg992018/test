import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBDUtils2 {
    private static DruidDataSource ds;
    static{
        Properties properties = new Properties();
        try {
            properties.load(DBDUtils2.class.getResourceAsStream("/dbconfig2.properties"));
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
