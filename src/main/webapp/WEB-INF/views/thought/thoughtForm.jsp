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
<link href="${ctx}/static/css/common.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<form id="inputForm" action="${ctx}/thought/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${thought.id}" />
		<fieldset>
			<legend>
				<small>Thought Management</small>
			</legend>
			<div class="control-group">
				<label for="thought_title" class="control-label">Thought Title:</label>
				<div class="controls">
					<input type="text" id="thought_title" name="title" value="${thought.title}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="Thought_type" class="control-label">Thought Type</label>
				<div class="controls">
					<form:select path="thought.type.id">
					   <form:option value="0" label="--- Select ---"/>
					   <form:options items="${thoughtTypes}" itemValue="id" itemLabel="title"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Thought Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${thought.description}</textarea>
				</div>
			</div>
			<c:if test="${action== 'process'}">
				<div class="control-group">
					<label for="actionable" class="control-label">Is this Actionable?</label>
					<div class="controls">
						<form:radiobutton path="thought.actionable" value="true" /> Yes  
						<form:radiobutton path="thought.actionable" value="false" /> No 
	        		</div>
				</div>
				<div class="control-group">
					<label for="outcome" class="control-label">Outcome</label>
					<div class="controls">
						<textarea id="outcome" name="outcome" class="input-large">${thought.outcome}</textarea>
					</div>
				</div>
			</c:if>
			
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="Submit" />&nbsp; 
					<input id="cancel_btn" class="btn" type="button" value="Retrun" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
</body>
</html>
