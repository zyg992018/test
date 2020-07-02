package zyg.businessImpl;

import zyg.business.Login;
import zyg.db.DbUtils;
import zyg.dbo.AdminDbo;
import zyg.entityImpl.AdminImpl;

public class LoginImpl implements Login {
    @Override
    public  AdminImpl login(String username, String password) {
        AdminImpl admin = null;
        try {
            DbUtils.begin();
            admin = AdminDbo.select(username);
            DbUtils.commit();
            if (admin != null) {
                if (!admin.getPassword().equals(password))
                    admin = null;
            } else {
                admin = null;
            }
        }catch (Exception e){
            DbUtils.rollback();
        }
        return admin;
    }
}
