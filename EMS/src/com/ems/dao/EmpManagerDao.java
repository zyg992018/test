package com.ems.dao;

import com.ems.entity.EmpManager;
import com.ems.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDao {
    private QueryRunner queryRunner = new QueryRunner();
    public EmpManager select(String username){
        try {
            EmpManager empManager = queryRunner.query(Dbutils.getConnection(),"select * from manager where username = ?"
                    ,new BeanHandler<EmpManager>(EmpManager.class),username);
            System.out.println(empManager);
            return empManager;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
