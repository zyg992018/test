import java.sql.Connection;
import java.sql.SQLException;

public class TestDruid {
    public static void main(String[] args) throws SQLException {
        for(int i =0 ;i <20;i++){
            Connection connection = DBDUtils2.getConnection();
            System.out.println(connection);
            //放回池中
            connection.close();
        }

    }
}
