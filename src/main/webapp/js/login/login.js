var rURL = "http://localhost:8080/login/welcome.jsp";

function submitLogin(){
	var uObj = $("#username");
	var pObj = $("#password");
	var submit_data={"user.username":uObj.val(),"user.password":pObj.val(),"rURL":rURL};
	$.ajax({
		// url:"/login/login.action",
		url:"/spring/login.action",
		type:'post',
		data:submit_data,
		success:function(responseText){
			if(responseText.status == "0"){
				window.location.href = rURL;
			}else{
				uObj.val("");
				pObj.val("");
				$("#login_error_info").html("登录失败");
			}
		}
	})

}

