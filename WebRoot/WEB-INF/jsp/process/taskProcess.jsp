<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>业务任务列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="<%=basePath%>resource/js/easyui/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=basePath%>resource/js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript"
	src="<%=basePath%>resource/js/common/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	
	  <table>
	   <tr>
	    <td>id</td>
	    <td>任务名称</td>
	    <td>流程id</td>
	    <td>流程定义id</td>
	    <td>操作</td>
	   </tr>
	   <c:forEach items="${tasks.lists}" var="s">
	    <tr>
	     <td>${s.id }</td>
	     <td>${s.name }</td>
	     <td>${s.processInstanceId}</td>
	     <td>${s.processDefinitionId}</td>
	     <td>
	     <c:if test="${s.assignee == null}">
	     <a href="<%=basePath%>process/signTask?taskId=${s.id }">签收</a> 
	     </c:if>
	     <c:if test="${s.assignee != null}">
	     <a href="<%=basePath%>process/completeTask?taskId=${s.id }">推进</a> 
	     </c:if>
	     <a href="<%=basePath%>process/handPIS?piId=${s.processInstanceId}">挂起</a> 
	     </td>
	    </tr>
	   </c:forEach>
	  </table>
	
</body>
</html>
