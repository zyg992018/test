package xi.jdbc;

import xi.jdbc.Dao.PersonDao;
import xi.jdbc.Entrty.Person;
import xi.jdbc.service.Service;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Person person = PersonDao.select("aa");
        System.out.println(person);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag = false;
                try {
                    flag = Service.getMoney(person,"12345678",900);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println(flag);
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Service.putMoney(person,"12345678",900);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        t.start();
        t1.start();
    }
}
