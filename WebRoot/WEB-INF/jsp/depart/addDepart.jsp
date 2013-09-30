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

<title>添加机构</title>

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
	 $("#departDiv").dialog({
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

 <div id="departDiv">
   <form id="myForm" action="<%=basePath%>depart/add" method="post">
    <input type="hidden" name="departPid" value="${departPid}"/>
    <table>
     <tr>
       <th>机构名称:</th><td><input type="text" name="departName"/> </td>
     </tr>    
     <tr>
       <th>机构地址:</th><td><input type="text" name="departAddr"/></td>
     </tr>
     <tr>
       <th>机构类型:</th><td><input type="radio" name="departState" value="1"/>政府派出机构<input type="radio" name="departState" value="2"/>政府组成部门 <input type="radio" name="departState" value="3"/>直属事业单位 <input type="radio" name="departState" value="4"/>职能科室</td>
     </tr>
    </table>
   </form>
 </div>

</body>
</html>