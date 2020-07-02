package zyg.servlet;

import zyg.businessImpl.LoginImpl;
import zyg.entityImpl.AdminImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = {"/aLogin"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s =req.getHeader("User-Agent");
        System.out.println(s);
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

        HttpSession httpSession = req.getSession();
        String sCode = (String)httpSession.getAttribute("code");
        if(!code.isEmpty()&&code.equalsIgnoreCase(sCode)){
            AdminImpl admin =  new LoginImpl().login(username,password);
            req.setAttribute("admin",admin);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/zyg/login.html");
        }
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        servletContext.setAttribute("aa","bb");
        servletContext.getAttribute("aa");
        servletContext.removeAttribute("aa");
        servletContext.getRealPath("/");
        servletContext.getContextPath();
//        resp.sendRedirect("/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
