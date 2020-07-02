<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ page errorPage="error.jsp"%>--%>
<%@ page session="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="nav.jsp"%>
    <%!
        int a = 10;
        public static int sum(int a,int b){
            return a+b;
        }
    %>
    <%System.out.println("控制台输出");out.print("html页面输出");%>
    <%=1+2%>
    <%=a%>
    <%=sum(1,3)%>
    <%--<%=1/0%>--%>
    <%
//        int a = 1/0;
    %>
    <%
        session.setAttribute("你好","yes");
//        out.print(session.getAttribute("你好"));
    %>
    <%@include file="footer.jsp"%>
    <jsp:forward page="error.jsp">
        <jsp:param name="name" value="张三"/>
        <jsp:param name="age" value="13"/>
    </jsp:forward>
</body>
</html>
