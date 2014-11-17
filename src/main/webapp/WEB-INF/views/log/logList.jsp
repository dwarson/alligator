<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>Log Management</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>

	<table id="contentTable" class="table">
		<thead>
			<tr>
				<th>Log</th>
				<th>Management</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${logs}" var="log">
				<tr>
					<td><a href="${ctx}/log/update/${log.id}">${log.title}</a></td>
					<td><a href="${ctx}/log/delete/${log.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="btn" href="${ctx}/log/create">New Log</a>
	</div>
</body>
</html>
