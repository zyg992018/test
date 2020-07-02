import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static final Properties PROPERTIES = new Properties();

    public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        PROPERTIES.load(new FileInputStream(new File("src/dbconfig.properties")));
        Class.forName(PROPERTIES.getProperty("driver"));
        Connection connection = DriverManager.getConnection(PROPERTIES.getProperty("URL"),PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
        return  connection;
    }
    public static void close(Connection connection, Statement statement, PreparedStatement preparedStatement) throws SQLException {
        if(statement!=null)statement.close();
        if(preparedStatement!=null)preparedStatement.close();
        if(connection!=null)connection.close();
    }
}
