<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    添加用户 <br>
    <sf:form method="post" modelAttribute="user" action="user/update">
    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="hidden" name="departId" value="${user.departId}"/>
    <input type="hidden" name="age" value="${user.age}"/>
    <input type="hidden" name="isSys" value="${user.isSys}"/>
    <input type="hidden" name="isDel" value="${user.isDel}"/>
    用户名:${user.userName}"<br/>
    姓  名:<input type="text" name="trueName" value="${user.trueName}"/><br/>
    <input type="submit" value="注册"/>
    </sf:form>
  </body>
</html>
