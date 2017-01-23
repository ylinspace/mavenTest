<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="/js/login/login.js"></script>
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<link rel="shortcut icon" href="/images/page.png"></link>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css"></link>
<html>
<head>
<title><s:text name="backendPage" /></title>
<script type="text/javascript">
	function register() {
		var username = $("#username").val();
		var password = $("#password").val();

		$.ajax({
			url : "register.action",
			type : "post",
			data : {
				"user.username" : username,
				"user.password" : password
			},
			success : function(responseText) {
				if (responseText.status == "0") {
					$("#result_text").html("注册成功！");
				} else {
					$("#result_text").html("注册失败！");
				}
			}
		})
	}

	function deleteUser() {
		var username = $("#username").val();

		$.ajax({
			url : "deleteUser.action",
			type : "get",
			data : {
				"user.username" : username
			},
			success : function(responseText) {
				if (responseText.status == "0") {
					$("#result_text").html("删除用户成功！");
				} else {
					$("#result_text").html("删除用户失败！");
				}
			}
		})
	}

	function queryUser() {

		$.ajax({
			url : "queryUsers.action",
			success : function(responseText) {
				if (responseText.status == "0") {
					$("#result_text").html("查询用户成功！");
					var result ="";
					$.each(responseText.list, function(i, item) {
						result += "<br />";
						result += "【" + i + "】:" + item.id + ":"
								+ item.username + ":" + item.password;
					})
					$("#query_text").html(result);
					
				} else {
					$("#result_text").html("查询用户失败！");
				}
			}
		})
	}
	
	function updateUser(){
		var username = $("#username").val();
		var password = $("#password").val();
		
		$.ajax({
			url:"updateUser.action",
			type:"post",
			data:{"user.username":username,"user.password":password},
			success:function(responseText){
				if(responseText.status == "0"){
					$("#result_text").html("更新成功！");
				}else{
					$("#result_text").html("更新失败！");
				}
			}
		})
	}
	
</script>

</head>
<body>
	<br />
	<br />
	<div align="center">
		<div style="">
			<div class="div_input_outter">
				<label style="color: #666; font-size: 14px">用户名:</label> <input
					id="username" class="input_class" type="text" name="username" placeholder="请输入用户名" /> <br />
			</div>
			<div class="div_input_outter">
				<label style="color: #666; font-size: 14px">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
				<input id="password" class="input_class" type="password"
					name="password" placeholder="请输入密码"/> <br />
			</div>
			<div>
				<label id="result_text"></label>
			</div>
			<input id="registerButton" class="btn btn-small  btn-primary" type="submit"
				onclick="register();" value="注册用户"> <input id="deleteButton"
				class="btn btn-small  btn-primary" type="submit" onclick="deleteUser();"
				value="删除用户"> <input id="queryButton" class="btn btn-small  btn-primary"
				type="submit" onclick="queryUser();" value="查询用户">
				<input id="updateButton" class="btn btn-small  btn-primary"
				type="submit" onclick="updateUser();" value="更新用户">
			<div>
				<label id="query_text"></label>
			</div>
		</div>
	</div>

</body>


</html>