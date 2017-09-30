<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="/js/login/login.js"></script>
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<link type="text/css" rel="stylesheet" href="/css/login/login.css"></link>
<link rel="shortcut icon" href="/images/page.png"></link>
<html>
<head>
<title><s:text name="loginPage" /></title>
</head>
<body>
	<br />
	<br />
	<div align="center">
		<div style="">
			<div class="div_input_outter">
				<label style="color: #666; font-size: 14px">用户名:</label> <input
					id="username" class="input_class" type="text" name="user.username" />
				<br />
			</div>
			<div class="div_input_outter">
				<label style="color: #666; font-size: 14px">密&nbsp;&nbsp;&nbsp;码:</label>
				<input id="password" class="input_class" type="password"
					name="user.password" /> <br />
			</div>
			<div style="color:#666666;height: 30px;width: 330px;text-align: left;">
				<label id="login_error_info"></label>
				<a style="position: relative;left: 231px;text-decoration:none;color: #666666;" href="backend.action">后台2</a>
			</div>
			<input id="loginButton" class="submit_class" type="submit" onclick="submitLogin();"
				value="登录">
		</div>
	</div>
</body>


</html>