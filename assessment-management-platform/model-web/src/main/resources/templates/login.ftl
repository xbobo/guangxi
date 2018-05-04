<!DOCTYPE html>
<html lang="en">
	<head>
		<title>test</title>
		<script type="text/javascript" src="lib/jquery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="lib/security/security.js"></script>
	</head>
	<body>
		<div class="login-div">
			<h2 style="text-align:center">test</h2>
			<form action="/admin/login"  method="post" class="loginForm">
				<lable>
					登录名：
				</lable>
				<div>
					<input placeholder="请输入用户名" type="text" id="username" name="username">	
				</div>
				<lable>
					登录密码：
				</lable>
				<div>
					<input placeholder="请输入密码" type="password" id="password" name="password">				
				</div>
				<div class="submit-div">
					<input type="button"  onclick="doLogin()" value="提交">
				<div>
			</form>
		</div>
	</body>
</html>
<script type="text/javascript">
	function doLogin(){
		var username = $('input[name=username]').val();
	    var password = $('input[name=password]').val();
	    if (username && password) {
	    	var publicKeyExponent = "${publicKeyExponent}";
	    	var publicKeyModulus = "${publicKeyModulus}";
	    	if (publicKeyExponent == "" || publicKeyExponent == "") {
	    		location.href = "/login";
	    		return;
	    	}
	    	RSAUtils.setMaxDigits(200);
	    	var key = new RSAUtils.getKeyPair(publicKeyExponent, "", publicKeyModulus);
	    	var encrypedPwd = RSAUtils.encryptedString(key,password);
	    	$('input[name=password]').val(encrypedPwd);
	    	$('.loginForm').submit();
	    } else {
	    	alert('用户名或密码不能为空!');
	    	return false;
	    }
	}
</script> 