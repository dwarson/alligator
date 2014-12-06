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
	<c:if test="${action == 'read'}">
		<form id="inputForm" action="${ctx}/bible/${action}" method="post" class="form-horizontal">
	</c:if>
	<c:if test="${action != 'read'}">
		<form id="inputForm" action="${ctx}/bibleChapter/${action}" method="post" class="form-horizontal">
	</c:if>
	<input type="hidden" name="id" value="${bibleChapter.id}" />
		<fieldset>
			<legend>
				<small>Bible Chapter Management</small>
			</legend>
			<div class="control-group">
				<label for="title" class="control-label">Title:</label>
				<div class="controls">
					<input type="text" id="title" name="title" value="${bibleChapter.title}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="bibleBook" class="control-label">Book</label>
				<div class="controls">
					<form:select path="bibleChapter.bibleBook.id">
					   <form:option value="" label="--- Select ---"/>
					   <form:options items="${books}" itemValue="id" itemLabel="title"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Bible Chapter Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${bibleChapter.description}</textarea>
				</div>
			</div>
			<c:if test="${action == 'read'}">
				<div class="control-group">
					<label for="notes" class="control-label">Notes</label>
					<div class="controls">
						<textarea id="notes" name="notes" class="input-large">${notes}</textarea>
					</div>
				</div>
			</c:if>
			<div class="form-actions">
				<c:if test="${action == 'read'}">
					<input id="submit_btn" class="btn btn-primary" type="submit"  value="Read" />&nbsp; 
				</c:if>
				<c:if test="${action != 'read'}">
					<input id="submit_btn" class="btn btn-primary" type="submit"  value="Submit" />&nbsp; 
				</c:if>
				<input id="cancel_btn" class="btn" type="button" value="Retrun" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
</body>
</html>
