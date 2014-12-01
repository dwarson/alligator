<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<body>
	<form id="inputForm" action="${ctx}/topic/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${topic.id}"/>
		<fieldset>
			<legend><small>Topic Management</small></legend>
			<div class="control-group">
				<label for="topic_title" class="control-label">Topic Title:</label>
				<div class="controls">
					<input type="text" id="topic_title" name="title"  value="${topic.title}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">Description:</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${topic.description}</textarea>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="Submit"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="Return" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
