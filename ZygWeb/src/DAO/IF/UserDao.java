package DAO.IF;

import Empity.IF.User;
import Empity.em.UserImpl;

public interface UserDao {
    public int insert(UserImpl user);
    public int update(UserImpl user);
    public int delete(UserImpl user);
    public UserImpl select(String username);
}
