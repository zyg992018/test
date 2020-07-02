package com.ems.dao;

import com.ems.entity.Emp;
import com.ems.entity.Page;
import com.ems.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    private QueryRunner queryRunner = new QueryRunner();
    public List<Emp> selectAll(Page page){
        List<Emp> empList = new ArrayList<>();
        try {
            empList =  queryRunner.query(Dbutils.getConnection(),"select * from emp limit ?,?",new BeanListHandler<Emp>(Emp.class),page.getStartRows(),page.getPageSize());
            return  empList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public long selectCount(){
        try {
            return queryRunner.query(Dbutils.getConnection(),"select count(*) from emp",new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
