import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestProperties {
    private static final Properties PROPERTIES = new Properties();

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        PROPERTIES.load(new FileInputStream(new File("src/dbconfig.properties")));
        System.out.println(PROPERTIES.getProperty("driver"));
        System.out.println(PROPERTIES.getProperty("password"));
        System.out.println(PROPERTIES.getProperty("URL"));
        System.out.println(PROPERTIES.getProperty("username"));
        Class.forName(PROPERTIES.getProperty("driver"));
        Connection connection = DriverManager.getConnection(PROPERTIES.getProperty("URL"),PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
    }
}




