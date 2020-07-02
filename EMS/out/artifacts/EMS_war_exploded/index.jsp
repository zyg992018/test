<%--
  Created by IntelliJ IDEA.
  User: 28120
  Date: 2020/7/1
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <style>
      *{
        margin: 0;
        padding: 0;
        text-align: center;
      }
      form{
        width: 500px;
        height: 300px;
        background-color: rebeccapurple;
        margin: 100px auto;
      }
    </style>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/managerLogin" method="post">
    <h1>登录</h1>
    <label for="user-name-label">用户名</label> <input type="text" name="username" id="user-name-label"><br>
    <label for="user-password-label">密码&nbsp;&nbsp;</label> <input type="password" name="password" id="user-password-label"><br>
    <label for="user-code-label">验证码</label><input type="text" name="code" id="user-code-label"><img src="${pageContext.request.contextPath}/code" alt="code"><br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
