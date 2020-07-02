<%--
  Created by IntelliJ IDEA.
  User: 28120
  Date: 2020/6/30
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("name")||cookie.getName().equals("password")){
                    out.print(cookie.getName()+":"+cookie.getValue()+"<br>");
                }
            }
        }
    %>
    <h1>${cookie.get("name").value}</h1>
    <input type="text" value="${cookie.get("name").value}">
    <input type="password" value="${cookie.get("password").value}"}>
</body>
</html>
