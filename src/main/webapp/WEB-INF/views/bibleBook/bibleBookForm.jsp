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
	<form id="inputForm" action="${ctx}/bibleBook/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${bibleBook.id}" />
		<fieldset>
			<legend>
				<small>BibleBook Management</small>
			</legend>
			<div class="control-group">
				<label for="bibleBook_title" class="control-label">Bible Book Title:</label>
				<div class="controls">
					<input type="text" id="bibleBook_title" name="title" value="${bibleBook.title}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="author" class="control-label">Author</label>
				<div class="controls">
					<textarea id="author" name="author" class="input-large">${bibleBook.author}</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="bookTime" class="control-label">Time</label>
				<div class="controls">
					<textarea id="bookTime" name="bookTime" class="input-large">${bibleBook.bookTime}</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="bookType" class="control-label">Type</label>
				<div class="controls">
					<textarea id="bookType" name="bookType" class="input-large">${bibleBook.bookType}</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Bible Book Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${bibleBook.description}</textarea>
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
