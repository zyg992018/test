package com.file.servlet;

import com.file.utils.UuidUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(value = "/list")
public class FileList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HashMap<String,String> FileNames = new HashMap<>();
        UuidUtils.Files(FileNames,new File(req.getServletContext().getRealPath("/WEB-INF/upload")));
        req.setAttribute("files",FileNames);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
