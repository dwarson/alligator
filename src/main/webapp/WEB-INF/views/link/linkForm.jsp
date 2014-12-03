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
	<form id="inputForm" action="${ctx}/link/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${link.id}" />
		<fieldset>
			<legend>
				<small>Link Management</small>
			</legend>
			<div class="control-group">
				<label for="link_title" class="control-label">Link Title:</label>
				<div class="controls">
					<input type="text" id="link_title" name="title" value="${link.title}" class="input-large required" />
				</div>
			</div>
			<div class="control-group">
				<label for="link_type" class="control-label">Link Type</label>
				<div class="controls">
					<form:select path="link.linkType.id">
					   <form:option value="0" label="--- Select ---"/>
					   <form:options items="${linkTypes}" itemValue="id" itemLabel="title"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
				<label for="url" class="control-label">URL</label>
				<div class="controls">
					<input type="url" id="url" name="url" value="${link.url}" class="input-large required" />
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Link Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${link.description}</textarea>
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
