<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
</head>
<body>
<section class="container">
	<form id="loginForm" action="${ctx}/login" method="post"  class="form-horizontal">
		<div class="control-group">
			<label for="username" class="control-label">User Name:</label>
			<div class="controls">
				<input type="text" id="username" name="username"  value="${username}" placeholder="Username or Email" class="input-medium required"/>
			</div>
		</div>
		<div class="control-group">
			<label for="password" class="control-label">Password:</label>
			<div class="controls">
				<input type="password" id="password" name="password" placeholder="Password" class="input-medium required"/>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<label class="checkbox" for="rememberMe"><input type="checkbox" id="rememberMe" name="rememberMe"/> Remember me</label>
				<input id="submit_btn" class="btn" type="submit" value="Login"/> <a class="btn" href="${ctx}/register">Sign up now</a>
			</div>
		</div>
			<%
				String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
				if(error != null){
				%>
					<div id="alert">
					 	<a class="alert" href="#alert">Login failed, please try again.</a>
					</div>
				<%
				}
			%>
	</form>
</section>
</body>
</html>
