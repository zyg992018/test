package com.file.servlet;

import com.file.utils.UuidUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(value = "/download")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String filename = req.getParameter("filename");
        File file = UuidUtils.FindFile(req.getServletContext().getRealPath("/WEB-INF/upload"),filename);
        resp.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename.split("_")[1],"UTF-8"));
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024*1024*100];
        int len = -1;
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        while ((len=fileInputStream.read(bytes))!=-1){
            servletOutputStream.write(bytes,0,len);
        }
        servletOutputStream.close();
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
