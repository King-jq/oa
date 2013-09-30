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
    <title>机构列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/icon.css" type="text/css"></link>
	<script type="text/javascript" src="<%=basePath%>resource/js/common/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/ztree/js/jquery.ztree.all-3.5.js"></script>
	
  </head>
  
  <body>
  <a class="button"  target="dialog" href="<%=basePath%>depart/add?pid=${depart.departId}">
   <span onclick="">添加子机构</span>
  </a>
  <a class="button"  target="dialog" href="<%=basePath%>user/add?departId=${depart.departId}">
   <span>添加机构用户</span>
  </a>
    机构信息:
    机构名称:${depart.departName}</br>
    
    <ul id="tt" class="easyui-tree tree" data-options="animate:true"></ul>  
    
    <script type="text/javascript">
		var json = ${json}; 
		$('#tt').tree({  
			  data:json,
			  onClick:function(node){
				  addChild(node);
			  }
		 });  
		
		function addChild(node){
			var pid = node.id;
			$.ajax({
				url:"<%=basePath%>depart/listJson?json",
				data:{"pid":pid},
				dataType:"json",
				method:"get",
				success:function(msg){
					alert(msg);
					if(msg){
						$('#tt').tree("append", node, msg);
					}
				}
			});
		}
	 </script>
	 
  </body>
</html>
