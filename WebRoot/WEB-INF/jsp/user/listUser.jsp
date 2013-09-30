<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <a href="<%=basePath%>user/add">添加</a>
    用户列表<br/>
    <c:forEach items="${users}" var="um">
      ${um.userId}---<a href="<%=basePath%>user/${um.userId}?json">${um.userName}</a>---${um.passwd}---${um.trueName} <a href="<%=basePath%>user/update/${um.userId}">修改</a><a href="<%=basePath%>user/delete/${um.userId}">删除</a><br/>
    </c:forEach>
  </body>
</html>
