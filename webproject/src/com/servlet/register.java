package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/register"})
public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名:"+name+"  密码:"+password);
//        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = new String(req.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        resp.setStatus(333);
        PrintWriter p = resp.getWriter();
        p.println("注册成功");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("用户名:"+name+"  密码:"+password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");

    }
}
