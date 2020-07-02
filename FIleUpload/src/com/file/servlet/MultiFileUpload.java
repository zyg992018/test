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
import java.util.Collection;

@WebServlet(value = "/multiFileUpload")
@MultipartConfig(maxRequestSize = 1024*1024*200,maxFileSize = 1024*1024*100)
public class MultiFileUpload extends HttpServlet {
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
        Collection<Part> parts = req.getParts();
        for(Part part : parts){
            String filename = part.getSubmittedFileName();
            if(filename!=null){
                if(filename.trim()!=""){
                    String basePath = req.getServletContext().getRealPath("/WEB-INF/upload");
                    part.write(UuidUtils.FilePath(basePath,filename)+"\\"+UuidUtils.Filename(filename));
                }
            }
        }
        resp.getWriter().println("<h1>上传成功</h1>");
    }
}
