package com.file.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "UploadController",value = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*100,maxRequestSize = 1024*1024*200)
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part part = req.getPart("file");

        String uploadPath = req.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdir();
        }
        part.write(uploadPath+"\\"+part.getSubmittedFileName());
        resp.getWriter().println("<h1>文件上传成功</h1>");
    }
}
