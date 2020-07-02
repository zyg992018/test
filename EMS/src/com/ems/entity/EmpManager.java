package com.ems.entity;

public class EmpManager {
    private String username;
    private String password;

    public EmpManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EmpManager() {
    }

    @Override
    public String toString() {
        return "EmpManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
