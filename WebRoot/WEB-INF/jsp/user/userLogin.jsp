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

<script type="text/javascript"
	src="<%=basePath%>resource/js/common/MD5.js" ></script>

<script type="text/javascript" >
	function login() {
		var passwd = document.getElementById("passwd");
		document.getElementById("truePasswd").value = hex_md5(passwd.value).toUpperCase();
		var form = document.getElementById("loginForm");
		form.submit();
	}
</script>

</head>

<body>
	登录
	<sf:form id="loginForm" action="user/login" method="post">
   用户名:<input type="text" name="userName" />
		<br />
   密码:<input id="passwd" type="password"/>
   <input type="hidden" name="passwd" id="truePasswd"/>
		<br />
		<input type="button" value="登录" onclick="login();" />
	</sf:form>
</body>
</html>
