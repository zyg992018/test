package com.ems.filter;

import com.ems.entity.EmpManager;
import sun.nio.cs.ext.MSISO2022JP;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/manager/*"})
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        EmpManager empManager = (EmpManager) session.getAttribute("empManager");
        if(empManager==null){
            filterChain.doFilter(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
