package com.servlet;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service{
    private AdminDbo adminDbo = new AdminDbo();
    @Override
    public Admin login(String username, String password) {
        Admin result = null;
        try {
            dbUtils.begin();
            Admin admin = adminDbo.select(username);
            dbUtils.commit();
            if (admin != null) {
                if (admin.getPassword().equals(password)) {
                    result = admin;
                }
            }
        }catch (Exception e){
            dbUtils.rollback();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> result = null;
        try {
            dbUtils.begin();
            result = adminDbo.selectAll();
            dbUtils.commit();
        }catch (Exception e){
            dbUtils.rollback();
        }
        return result;
    }
}
