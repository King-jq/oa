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
<script type="text/javascript">
$(function(){
	 $("#addLeave").dialog({
		 modal:true,
		 closable:false
	 });
});

</script>
</head>
<body>
  <div id="addLeave" title="填写请假单" modal="true">
	  <form id="myLeave" action="<%=basePath%>leave/startLeave" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="key" value="${key}"/>
	    <table>
	      <tr>
	        <th>开始时间:</th><td><input class="easyui-datetimebox" required style="width:150px" type="text" name="startDate"/></td>
	      </tr>
	      <tr>
	        <th>销假时间:</th><td><input class="easyui-datetimebox" required style="width:150px" type="text" name="endDate"/></td>
	      </tr>
	      <tr>
	        <th>请假原因:</th><td> <input type="text" name="cause"/></td>
	      </tr>
	      <tr>
	        <th colspan="2"><input type="submit" value="提交" /></th>
	      </tr>
	    </table>	  
	  </form>
	</div>
</body>
</html>