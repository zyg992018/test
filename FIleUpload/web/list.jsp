<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件集合</title>
</head>
<body>
    <table>
        <tr>
            <th>文件</th>
            <th>操作</th>
        </tr>
        <c:forEach var="entry" items="${files}">
            <tr>
                <td>${entry.value}</td>
                <td><a href="${pageContext.request.contextPath}/download?filename=${entry.key}_${entry.value}">下载</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
