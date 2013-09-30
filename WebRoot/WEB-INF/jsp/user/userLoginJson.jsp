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

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>resource/js/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>resource/js/common/MD5.js" ></script>
<script type="text/javascript" src="<%=basePath%>resource/js/common/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/easyui/jquery.easyui.min.js"></script>


<script type="text/javascript" >
	var login;
	$(function (){
		login = $('#login').dialog({
			modal:true,
			closable:false,
			buttons:[{
				text:'登录',
				handler:function login(){
					loginJson();
				}},
				{text:'注册',
				  handler:function reg(){
					  window.location='<%=basePath%>user/add';
				}}]
		});
	});
	
	function loginJson() {
		var newPW = hex_md5(document.getElementById("passwd").value).toUpperCase();
		var userName = document.getElementById("userName").value;
		$.ajax({
			url:'<%=basePath%>user/loginJson?json',
			data:{userName:userName,passwd:newPW},		
			method:'POST',
			dataType:'json',
			success:function(msg){
				if(!msg.state){
					$.messager.alert('登录失败',"密码或用户名错误!");
				}else{
					window.location='<%=basePath%>user/index';
				}
			},
			error:function(msg){
				$.messager.alert('登录失败',"密码或用户名错误!");
			}
		});
	}
</script>

</head>

<body>
    <div id="login" title="登录" style="width:270px;height:150px;top:100px">
      <table>
       <tr>
         <td><th>用户名:</th></td>
         <td><input type="text" id="userName" name="userName" /></td>
       </tr>
       <tr>
         <td><th>密&nbsp;&nbsp;码:</th></td>
         <td>
           <input id="passwd" type="password"/>
         </td>
       </tr>
      </table>
    </div>
    
   
</body>
</html>
