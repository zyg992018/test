package DAO.Impl;

import DB.DBUtils;
import Empity.IF.User;
import Empity.em.UserImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl {
    QueryRunner queryRunner = new QueryRunner();
    public int insert(UserImpl user){
        return 1;
    }
    public int update(UserImpl user){
        return 1;
    }
    public int delete(UserImpl user){
        return 1;
    }
    public UserImpl select(String username){
        UserImpl user = null;
        try {
            user = queryRunner.query(DBUtils.getConnection(),"SELECT * FROM User WHERE username=?",new BeanHandler<>(UserImpl.class),username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public List<UserImpl> selectAll(String username){
        List<UserImpl> users = null;
        try {
            users = queryRunner.query(DBUtils.getConnection(),"SELECT * FROM User",new BeanListHandler<>(UserImpl.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
