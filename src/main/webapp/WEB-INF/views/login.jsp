<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${ctx}/static/css/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>Login to Alligator</h1>
			<form id="loginForm" action="${ctx}/login" method="post">
				<p>
					<input type="text" id="username" name="username"
						value="${username}" placeholder="Username or Email" />
				</p>
				<p>
					<input type="password" id="password" name="password"
						placeholder="Password" />
				</p>
				<p class="remember_me">
					<label for="rememberMe"><input type="checkbox"
						id="rememberMe" id="rememberMe" /> Remember me </label>
				</p>
				<p class="submit">
					<input type="submit" value="Login">
				</p>
				
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
		</div>
	</section>
</body>
</html>
