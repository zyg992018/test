<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 28120
  Date: 2020/6/30
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <%
        pageContext.getRequest().setAttribute("key",1);
        pageContext.getSession().setAttribute("key2",2);
        pageContext.getServletContext().setAttribute("key3",3);
    %>
    <h1><%=pageContext.getRequest().getAttribute("key")%></h1>
    <h1><%=pageContext.getSession().getAttribute("key2")%></h1>
    <h1><%=pageContext.getServletContext().getAttribute("key3")%></h1>
    <hr>
    <h1>${requestScope.key}</h1>
    <h1>${sessionScope.key2}</h1>
    <h1>${applicationScope.key3}</h1>
    <%
        int[] a = new int[]{1,2,3};
        request.setAttribute("array",a);
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        request.setAttribute("arrayList",list);
        Map<String,String> m = new HashMap<>();
        m.put("中国","CN");
        request.setAttribute("m",m);
    %>
    <h1>${requestScope.arrayList[0]}</h1>
    <h2>${arrayList.get(2)}</h2>
    <h3>${array[1]}</h3>
    <h3>${requestScope.m["中国"]}</h3>
<h3>${m.get("中国")}</h3>
</body>
</html>
