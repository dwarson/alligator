<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>

<body>
	<form id="inputForm" action="${ctx}/actionPlan/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${actionPlan.id}" />
		<fieldset>
			<legend>
				<small>ActionPlan Management</small>
			</legend>
			<div class="control-group">
				<label for="actionPlan_title" class="control-label">ActionPlan Title:</label>
				<div class="controls">
					<input type="text" id="actionPlan_title" name="title" value="${actionPlan.title}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="actionPlan_type" class="control-label">ActionPlan Type</label>
				<div class="controls">
					<form:select path="actionPlan.type">
					   <form:option value="0" label="--- Select ---"/>
					   <form:options items="${actionPlanTypes}"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">ActionPlan Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${actionPlan.description}</textarea>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="Submit" />&nbsp; 
					<input id="cancel_btn" class="btn" type="button" value="Retrun" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
</body>
</html>
