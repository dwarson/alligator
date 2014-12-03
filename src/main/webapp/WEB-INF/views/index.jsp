<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
</head>
<body>
	<form id="index">
		<h4>Welcome, ${name}!</h4>
		<div>
			<h5 class="nav">Christian Life</h5>
			<ul>
				<li><a href="${ctx}/bible">Bible Reading</a></li>
			</ul>
		</div>
		<div>
			<h5>Daily Task</h5>
			<ul>
				<li><a href="${ctx}/log">Log Management</a></li>
				<li><a href="${ctx}/thought">Thought Management</a></li>
				<li><a href="${ctx}/actionPlan">Action Plan Management</a></li>
			</ul>
		</div>
		<div>
			<h5>Tools</h5>
			<ul>
				<li><a href="${ctx}/link">Links</a></li>
			</ul>
		</div>
	</form>
</body>
</html>
