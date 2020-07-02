package zyg.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",value = {"/getSession"})
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("aa","bb");
        httpSession.getAttribute("aa");
        httpSession.setMaxInactiveInterval(20);
        httpSession.invalidate();
        httpSession.removeAttribute("aa");
        response.encodeRedirectURL("/get");
        System.out.println(httpSession.getId());
    }
}
