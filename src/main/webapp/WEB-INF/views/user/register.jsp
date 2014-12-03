<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>User Register</title>
	<script>
		$(document).ready(function() {
			$("#loginName").focus();
			$("#inputForm").validate({
				rules: {
					username: {
						remote: "${ctx}/register/checkUsername"
					}
				},
				messages: {
					username: {
						remote: "Username is already exist!"
					}
				}
			});
		});
	</script>
</head>
<body>
	<form id="inputForm" action="${ctx}/register" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>Create Account</small></legend>
			<div class="control-group">
				<label for="loginName" class="control-label">Username:</label>
				<div class="controls">
					<input type="text" id="username" name="username" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="name" class="control-label">Name:</label>
				<div class="controls">
					<input type="text" id="name" name="name" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">Password:</label>
				<div class="controls">
					<input type="password" id="plainPassword" name="plainPassword" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">Confirm Password:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large required" equalTo="#plainPassword"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="Submit"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="Retrun" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
