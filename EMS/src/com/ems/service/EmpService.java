package com.ems.service;

import com.ems.dao.EmpDao;
import com.ems.entity.Emp;
import com.ems.entity.Page;
import com.ems.utils.Dbutils;

import java.util.List;

public class EmpService {
    private EmpDao empDao = new EmpDao();
    public List<Emp> showAllEmpByPage(Page page){
        Dbutils.begin();
        List<Emp> empList =null;
        try{
            empList = empDao.selectAll(page);
            Dbutils.commit();
            Long l = empDao.selectCount();
            page.setTotalCounts(l);
        }catch (Exception e){
            Dbutils.rollback();
            e.printStackTrace();
        }
        return empList;
    }
}
