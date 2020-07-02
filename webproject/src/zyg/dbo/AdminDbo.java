package zyg.dbo;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zyg.entity.Admin;
import zyg.db.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import zyg.entityImpl.AdminImpl;

import java.sql.SQLException;
import java.util.List;

public class AdminDbo {
    private static QueryRunner queryRunner = new QueryRunner();
    public static AdminImpl select(String username){
        AdminImpl admin= null;
        try {
            admin = queryRunner.query(DbUtils.getConnection(),"SELECT * FROM Admin WHERE username=?",
                    new BeanHandler<>(AdminImpl.class),username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }
    public static List<AdminImpl> selectAll(){
        List<AdminImpl> admins = null;

        try {
            admins = queryRunner.query(DbUtils.getConnection(),"SELECT * FROM Admin",
                    new BeanListHandler<>(AdminImpl.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admins;
    }
    public static int insert(Admin admin){
        return 1;
    }
    public static int delete(Admin admin){
        return 1;
    }
    public static int update(Admin admin){
        return 1;
    }
}
