package com.ems.controller;

import com.ems.entity.EmpManager;
import com.ems.service.EmpManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/managerLogin")
public class EmpManagerLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        if(code.equalsIgnoreCase((String)session.getAttribute("code"))) {
            EmpManager empManager = new EmpManagerService().login(username,password);
            if (empManager != null) {
                session.setAttribute("manager", empManager);
                resp.sendRedirect(req.getContextPath() + "/manager/showAllEmp");
            } else {
                resp.getWriter().println("登录失败");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }
        }else {
            resp.getWriter().println("登录失败");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }
}
