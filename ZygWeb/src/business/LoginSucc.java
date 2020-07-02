package business;

import Empity.em.UserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = {"/success"})
public class LoginSucc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserImpl user = (UserImpl) req.getAttribute("user");
        System.out.println(user);
        Cookie cookie = new Cookie("username",user.getUsername());
        cookie.setMaxAge(60*60*7);
        resp.addCookie(cookie);
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        resp.sendRedirect("/ZygWeb_war_exploded/src/main.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
