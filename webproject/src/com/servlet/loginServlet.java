package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/login"})
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ServiceImpl service = new ServiceImpl();
        Admin admin = service.login(username,password);
        PrintWriter printWriter = resp.getWriter();
        if(admin != null){
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>登录成功");
            printWriter.println("</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("登录成功！");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }else {
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>登录失败");
            printWriter.println("</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("登录失败！");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
