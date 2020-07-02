<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 28120
  Date: 2020/6/30
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("username","小红");
        request.setAttribute("age",19);
        List<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小红");
        request.setAttribute("arrayList",list);
    %>
    <c:if test="${username.equals('小明')}">
        <h1>登录成功 ${username}</h1>
    </c:if>
    <c:if test="${username ne ('小明')}">
        <h1>用户${username}不存在</h1>
    </c:if>
    <c:choose>
        <c:when test="${age lt 20}"><h1>年纪小</h1></c:when>
        <c:when test="${age gt 20}"><h1>年纪大</h1></c:when>
        <c:otherwise><h1>年级刚好</h1></c:otherwise>
    </c:choose>
<c:forEach var="s" items="${arrayList}" begin="0" end="${arrayList.size()-1}" step="1" varStatus="i">
    <h1>${s}   ${i.first}  ${i.index} ${i.last} ${i.count} ${i.step} ${i.current}</h1>
</c:forEach>

    <a href="<c:url context='${pageContext.request.contextPath}' value='/index.jsp'></c:url>">aaaaa</a>

</body>
</html>