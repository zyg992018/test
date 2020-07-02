package com.servlet;

import java.util.List;

public interface Service {
    public Admin login(String username, String password);
    public List<Admin> showAllAdmin();
}
