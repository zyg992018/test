<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/multiFileUpload" enctype="multipart/form-data" method="post">
    <label for="user-name-label">用户名</label><input type="text" name="username" id="user-name-label">
    <label for="user-password-label">用户名</label><input type="password" name="password" id="user-password-label">
    <label for="user-file1-label">文件</label><input type="file" name="file1" id="user-file1-label" value="选择文件">
    <label for="user-file2-label">文件</label><input type="file" name="file2" id="user-file2-label" value="选择文件">
    <input type="submit" value="提交">
</form>
</body>
</html>
