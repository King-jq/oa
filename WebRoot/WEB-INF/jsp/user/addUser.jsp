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

<title>添加用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>resource/js/common/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#addUser").dialog({
		 modal:true,
		 closable:false,
		 buttons:[{
			 text:"添加",
			 handler:function(){
				$("#myForm").submit(); 
			 }
		 },{
			 text:"取消",
			 handler:function(){
				 history.go(-1);
			 }
		 }]
	 });
 });
</script>
</head>

<body>
	<div id="addUser" title="添加用户" modal="true">
	  <form id="myForm" action="<%=basePath%>user/add" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="departId" value="${departId}">
	    <table>
	      <tr>
	        <th>用户名:</th><td><input type="text" name="userName"/></td>
	      </tr>
	      <tr>
	        <th>密&nbsp;&nbsp;码:</th><td><input type="password" name="passwd"/></td>
	      </tr>
	      <tr>
	        <th>姓&nbsp;&nbsp;名:</th><td> <input type="text" name="trueName"/></td>
	      </tr>
	      <tr>
	        <th>年&nbsp;&nbsp;龄:</th><td><input type="text" name="age"/></td>
	      </tr>
	      <tr>
	        <th>管理员:</th><td><input type="checkbox" value="1" name="isSys"/></td>
	      </tr>
	      <tr>
	       <th>头&nbsp;&nbsp;像:</th><td><input type="file" name="file"/></td>
	      </tr>
	    </table>	  
	  </form>
	</div>
</body>
</html>
