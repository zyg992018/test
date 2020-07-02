package zyg.business;

import zyg.entityImpl.AdminImpl;

public interface Login {
    public  AdminImpl login(String username, String password);
}
