<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link href="${ctx}/static/css/login.css" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>Login to Alligator</h1>
			<sf:form method="POST" modelAttribute="user" action="/user">
				<p>
					<sf:input path="username" size="30" id="user_email"
						placeholder="Username or Email" />
					<sf:errors path="username" />
				</p>
				<p>
					<sf:password path="password" size="30" id="password"
						placeholder="Password" />
					<sf:errors path="password" />
				</p>
				<p class="remember_me">
					<label> <sf:checkbox path="remember" id="remember_me" /> 
						Remember me
					</label>
				</p>
				<p class="submit">
					<input type="submit" value="Login">
				</p>
			</sf:form>
		</div>
	</section>
</body>
</html>
