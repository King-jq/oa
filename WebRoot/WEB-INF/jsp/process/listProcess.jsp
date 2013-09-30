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

<title>流程定义列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>resource/js/common/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
  <table border="1">
    <tr>
      <td>deploymentId</td>
      <td>id</td>
      <td>name</td>
      <td>key</td>
      <td>resourceName</td>
      <td>version</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${pros.lists}" var="p">
      <tr>
      <td>${p.deploymentId}</td>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.key}</td>
      <td>${p.resourceName}</td>
      <td>${p.version}</td>
      <td>
      <a title="请假" href='<%=basePath%>leave/startLeave?key=${p.key}'>请假</a>  
      <a title="挂起" href='<%=basePath%>process/handPDF?pdId=${p.id}'>挂起</a>
      </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>