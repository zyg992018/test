package com.file.servlet;

import com.file.utils.UuidUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(value = "/uploads")
@MultipartConfig(maxFileSize = 1024*1024*100,maxRequestSize = 1024*1024*200)
public class Uploads  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part part = req.getPart("file");
        String path = req.getServletContext().getRealPath("/WEB-INF/upload");
        path = UuidUtils.FilePath(path,part.getSubmittedFileName());
        part.write(path + "\\"+UuidUtils.Filename(part.getSubmittedFileName()));
        resp.getWriter().println("<h1>上传成功</h1>");
    }
}
