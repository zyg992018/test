package servlet;

import DAO.Impl.UserDaoImpl;
import DB.DBUtils;
import Empity.em.UserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession httpSession = req.getSession();
        if (code.equalsIgnoreCase((String)httpSession.getAttribute("code"))){
            DBUtils.begin();
            UserDaoImpl userDao= new UserDaoImpl();
            DBUtils.commit();
            UserImpl user = userDao.select(username);
            if(user!=null && user.getPassword().equals(password)){
                req.setAttribute("user",user);
                System.out.println(username);
                req.getRequestDispatcher("/success").forward(req,resp);
            }else{
                System.out.println(code);
                resp.sendRedirect("/ZygWeb_war_exploded/login.html");
            }
        }else{
            System.out.println(code);
            resp.sendRedirect("/ZygWeb_war_exploded/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
