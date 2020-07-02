package com.servlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDbo {
    private QueryRunner queryRunner = new QueryRunner();
    public int insert(Admin a){
        return 1;
    }
    public int delete(String  name){
        return 1;
    }
    public int update(Admin a){
        return 1;
    }
    public Admin select(String username){
        Admin a =null;
        try {
            a = queryRunner.query(dbUtils.getConnection(),"select * from admin where username=?",
                    new BeanHandler<Admin>(Admin.class),username);
            System.out.println(username+a);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
    public List<Admin> selectAll(){
        List<Admin> adminList = null ;
        try {
            adminList = queryRunner.query(dbUtils.getConnection(),"select * from Admin",
                    new BeanListHandler<Admin>(Admin.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return adminList;
    }
}
