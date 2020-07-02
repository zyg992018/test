package zyg.response;

import zyg.entity.Admin;
import zyg.entityImpl.AdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(value = {"/login.jsp"})
public class LoginRes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        Admin admin = (Admin)req.getAttribute("admin");
        PrintWriter printWriter = resp.getWriter();

        if(admin!=null){
            Cookie c = new Cookie("t",System.currentTimeMillis()+"");
            c.setPath("/zyg/get");
            c.setMaxAge(60*60);
            Cookie cookie = new Cookie("username",((AdminImpl)admin).getUsername());
            Cookie cookie1 = new Cookie("password",((AdminImpl)admin).getPassword());
            cookie.setMaxAge(60*60*7);
            cookie.setPath("/zyg/");
            cookie1.setPath("/zyg/");
            cookie1.setMaxAge(60*60*7);
            resp.addCookie(c);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            Cookie cookie2 = new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncoder.encode("张三","UTF-8"));
            cookie2.setPath("/zyg/");
            cookie2.setMaxAge(60*60*7);
            resp.addCookie(cookie2);

            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset=utf8>");
            printWriter.println("<title>登录成功</title>");
            printWriter.println("</head>");
            printWriter.println("<body> 登录成功");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }else{
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset=utf8>");
            printWriter.println("<title>登录失败</title>");
            printWriter.println("</head>");
            printWriter.println("<body> 登录失败");
            printWriter.println("</body>");
            printWriter.println("</html>");
        }
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
