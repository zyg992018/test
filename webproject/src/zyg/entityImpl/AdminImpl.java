package zyg.entityImpl;


import zyg.entity.Admin;

public class AdminImpl implements Admin {
    private String username = null;
    private String password = null;
    private String iphone = null;
    private String address = null;
    public AdminImpl(){}
    public AdminImpl(String username, String password, String iphone, String address) {
        this.username = username;
        this.password = password;
        this.iphone = iphone;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIphone() {
        return iphone;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AdminImpl{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", iphone='" + iphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminImpl admin = (AdminImpl) o;
        return username.equals(admin.username);
    }

}
