<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
</head>
<body>
	<h2>Welcome</h2>
	<form id="index">
		<fieldset>
			<legend>Profile</legend>
			<div>
				<label for="user_full_name">Full Name:</label> ${name}
			</div>
		</fieldset>
		<div>
			<h2 class="nav">
        		<span>Daily Task</span>
            </h2>
			<ul class="list">
				<li class="listTypesc"><a href="${ctx}/log">Log Management</a></li>
				<li class="listTypesc"><a href="${ctx}/topic">Topic Management</a></li>
			</ul>
		</div>
	</form>
</body>
</html>
