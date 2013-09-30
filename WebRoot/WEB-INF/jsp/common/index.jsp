<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>主页</title>

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
function newOpen(obj, url){
	var id = obj.id;
	if($("#tabs_"+id).html() == null){
		var title=obj.innerHTML;
		$('#content').tabs('add',{  
		    title:title,  
		    closable:true,   
            cache : false,   
            content:'<iframe name=iframe_"'+id+'" id=tabs_'+id+' src="'+url+'" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>'
		});
	}
}
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:30px;" align="center">
		 <span style="font-size: 20px">金强  2013.08.31</span>
		</div>
		<div data-options="region:'west',split:true" align="center" title="菜单" style="width:200;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="Title1" data-options="selected:true" style="padding:10px;">
				<ul>
				  <li><span id="1" onclick="newOpen(this,'<%=basePath%>depart/list')">机构管理</span></li>
				  <li><span id="2" onclick="newOpen(this,'<%=basePath%>process/deploy')">流程部署</span> </li>
				  <li><span id="3" onclick="newOpen(this,'<%=basePath%>process/list')">流程列表</span> </li>
				  <li><span id="4" onclick="newOpen(this,'<%=basePath%>process/myTasks')">任务列表</span></li>
				</ul>
				</div>
				<div title="Title2" style="padding:10px;">
					content2
				</div>
				<div title="Title3" style="padding:10px">
					content3
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:''" >
			<div id="content" class="easyui-tabs tabs-container" style="width:auto;height:auto;" data-options="tools:'#tab-tools'">
			<div title="首页" style="width:auto;height:auto">
			</div>
		 </div>
	  </div>
	</div>
</body>
</html>