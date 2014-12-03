<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
</head>
<body>
	<form id="index">
		<fieldset>
			<legend>User Profile</legend>
			<div>
				<label for="user_full_name">Name: ${name}</label>
			</div>
		</fieldset>
		<div>
			<h4 class="nav">
        		<span>Christian Life</span>
            </h4>
			<ul class="list">
				<li class="listType"><a href="${ctx}/bible">Bible Reading</a></li>
			</ul>
		</div>
		<div>
			<h4 class="nav">
        		<span>Daily Task</span>
            </h4>
			<ul class="list">
				<li class="listType"><a href="${ctx}/topic">Topic Management</a></li>
				<li class="listType"><a href="${ctx}/log">Log Management</a></li>
				<li class="listType"><a href="${ctx}/thought">Thought Management</a></li>
				<li class="listType"><a href="${ctx}/actionPlan">Action Plan Management</a></li>
			</ul>
		</div>
	</form>
</body>
</html>
