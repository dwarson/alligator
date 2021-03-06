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
	<form id="inputForm" action="${ctx}/log/${action}" method="post" class="form-horizontal">
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
				<label for="log_type" class="control-label">Log Type</label>
				<div class="controls">
					<form:select path="log.logType.id">
					   <form:option value="0" label="--- Select ---"/>
					   <form:options items="${logTypes}" itemValue="id" itemLabel="title"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
				<label for="start_time" class="control-label">Start Time</label>
				<div class="controls">
					<input type="text" id="start_time" name="startTime" value="${log.startTime}"	class="input-large required" minlength="3" />
				</div>
			</div>
			<div class="control-group">
				<label for="end_time" class="control-label">End Time</label>
				<div class="controls">
					<input type="text" id="end_time" name="endTime" value="${log.endTime}"	class="input-large required" minlength="3" />
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Log Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${log.description}</textarea>
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
