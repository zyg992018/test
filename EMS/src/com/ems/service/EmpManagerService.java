package com.ems.service;

import com.ems.dao.EmpManagerDao;
import com.ems.entity.EmpManager;
import com.ems.utils.Dbutils;

public class EmpManagerService {
    public EmpManager login(String username,String password){
        Dbutils.begin();
        try {
            EmpManager empManager = new EmpManagerDao().select(username);
            if(empManager!=null){
                if(password.equals(empManager.getPassword())){
                    return empManager;
                }
            }
            Dbutils.commit();
        }catch (Exception e){
            Dbutils.rollback();
            e.printStackTrace();
        }
        return null;
    }

}
