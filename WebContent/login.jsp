<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tags.tld" prefix="s"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<title>登录界面</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css/login.css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<s:form action="loginAction" namespace="/login">
				<div class="loginBox">
					<div class="loginBoxCenter">
						<p>
							<s:label for="username">
								用户名：
							</s:label>
						</p>
						<p>
							<s:textfield name="sysUserVO.username" cssClass="loginInput"
								id="username" autofocus="autofocus" required="required"
								autocomplete="off" placeholder="请输入用户名">
							</s:textfield>
						</p>
						<p>
							<s:label for="password">
								密码：
							</s:label>
						</p>
						<p>
							<s:password name="sysUserVO.password" cssClass="loginInput"
								id="password" required="required" placeholder="请输入密码">
							</s:password>
						</p>
						<p>
							${ actionMessages[0] }${actionErrors[0]}
						</p>
					</div>
					<div class="loginBoxButtons">
						<input id="remember" type="checkbox" name="remember" />
						<label for="remember">
							记住登录状态
						</label>
						<s:submit cssClass="loginBtn" value="登  录"
							action="loginAction!login" onclick="return vaildateLogin();">
						</s:submit>
					</div>
				</div>
			</s:form>
		</div>
	</body>
	<script type="text/javascript">
	function vaildateLogin() {
		var userId = $("#username").val();
		var password = $("#password").val();
		var msg = "";
		if (userId == "") {
			msg += "用户名不能为空！\n";
		}
		if (password == "") {
			msg += "密码不能为空！";
		}
		if (msg.length > 0) {
			alert(msg);
			return false;
		}

		return true;
	}
</script>
</html>