<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("李佳欣",23);
        Integer integer = (Integer) pageContext.getAttribute("李佳欣");
        Integer integer1 = (Integer) request.getAttribute("廖忠友");
        Integer integer2 = (Integer) request.getSession().getAttribute("张永刚");
        String s = (String) application.getAttribute("哦哦");
    %>
<%=integer%>
<%=integer1%>
<%=integer2%>
<%=s%>
</body>
</html>
