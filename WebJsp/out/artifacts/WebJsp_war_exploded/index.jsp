<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  language="java" isErrorPage="false" pageEncoding="utf-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
  <%!
    public int sum(int a,int b){
      return a+b;
    }
  %>
  <%
    System.out.println(sum(1,2));
    out.print("<h1>你好呀</h1>");
  %>
  <%=new Date(System.currentTimeMillis())%>
  <h2><%=sum(12,34)%></h2>
  <jsp:include page="JSP/footer.jsp"></jsp:include>
  <jsp:useBean id="user" class="com.zyg.User" ></jsp:useBean>
  <jsp:setProperty name="user" property="name" value="zyg"></jsp:setProperty>
  <jsp:setProperty name="user" property="password" value="12345"></jsp:setProperty>
  用户名：<jsp:getProperty name="user" property="name"/>
  密码：<jsp:getProperty name="user" property="password"/>

  <a href="<c:url context='${pageContext.request.contextPath}' value='/JSTL/jstl1.jsp'></c:url>">bbbb</a>
  </body>
</html>
