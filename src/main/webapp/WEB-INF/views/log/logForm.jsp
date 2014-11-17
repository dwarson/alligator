<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Log Management</title>
</head>

<body>
	<form id="inputForm" action="${ctx}/log/${action}" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${log.id}" />
		<fieldset>
			<legend>
				<small>Log Management</small>
			</legend>
			<div class="control-group">
				<label for="log_title" class="control-label">Log Title:</label>
				<div class="controls">
					<input type="text" id="log_title" name="title" value="${log.title}"
						class="input-large required" minlength="3" />
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Log
					Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${log.description}</textarea>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit"
					value="Submit" />&nbsp; <input id="cancel_btn" class="btn"
					type="button" value="Retrun" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
	<script>
		
	</script>
</body>
</html>
