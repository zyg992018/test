<%--
  Created by IntelliJ IDEA.
  User: 28120
  Date: 2020/7/1
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Emp</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>salary</th>
            <th>age</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${empList}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.salary}</td>
                <td>${i.age}</td>
                <td><a href="#">修改</a></td>
                <td><a href="#">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <c:if test="${page.pageIndex eq 1}">
                <td><a>首页</a></td>
            </c:if>
            <c:if test="${page.pageIndex ne 1}">
                <td><a href="${pageContext.request.contextPath}/manager/showAllEmp?pageIndex=1">首页</a></td>
            </c:if>
            <c:if test="${page.pageIndex lt 2}">
                <td><a>上一页</a></td>
            </c:if>
            <c:if test="${page.pageIndex gt 1}">
                <td><a href="${pageContext.request.contextPath}/manager/showAllEmp?pageIndex=${page.pageIndex-1}">上一页</a></td>
            </c:if>
            <c:if test="${page.pageIndex gt (page.totalPages-1)}">
                <td><a>下一页</a></td>
            </c:if>
            <c:if test="${page.pageIndex lt page.totalPages}">
                <td><a href="${pageContext.request.contextPath}/manager/showAllEmp?pageIndex=${page.pageIndex+1}">下一页</a></td>
            </c:if>
            <c:if test="${page.pageIndex eq page.totalPages}">
                <td><a>尾页</a></td>
            </c:if>
            <c:if test="${page.pageIndex ne page.totalPages}">
                <td><a href="${pageContext.request.contextPath}/manager/showAllEmp?pageIndex=${page.totalPages}">尾页</a></td>
            </c:if>

        </tr>
    </table>
</body>
</html>
