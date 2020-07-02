package com.ems.controller;

import com.ems.entity.Emp;
import com.ems.entity.Page;
import com.ems.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/manager/showAllEmp")
public class ShowAllEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageIndex = req.getParameter("pageIndex");
        if(pageIndex==null){
            pageIndex = "1";
        }
        Page page = new Page(Integer.valueOf(pageIndex));
        EmpService empService = new EmpService();
        List<Emp>  empList= empService.showAllEmpByPage(page);
        System.out.println(empList.get(0));
        req.setAttribute("empList",empList);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/showAllEmp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
