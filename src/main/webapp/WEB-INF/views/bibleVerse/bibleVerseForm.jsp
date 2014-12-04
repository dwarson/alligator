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
	<form id="inputForm" action="${ctx}/bibleVerse/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${bibleVerse.id}" />
		<fieldset>
			<legend>
				<small>Bible Verse Management</small>
			</legend>
			<div class="control-group">
				<label for="title" class="control-label">Title:</label>
				<div class="controls">
					<input type="text" id="title" name="title" value="${bibleVerse.title}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="contentEn" class="control-label">English Content:</label>
				<div class="controls">
					<input type="text" id="contentEn" name="contentEn" value="${bibleVerse.contentEn}"
						class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="contentCn" class="control-label">Chinese Content:</label>
				<div class="controls">
					<input type="text" id="contentCn" name="contentCn" value="${bibleVerse.contentCn}"
						class="input-large required"/>
			</div>
			</div>
			<div class="control-group">
				<label for="bibleChapter" class="control-label">Chapter</label>
				<div class="controls">
					<form:select path="bibleVerse.bibleChapter.id">
					   <form:option value="" label="--- Select ---"/>
					   <form:options items="${chapters}" itemValue="id" itemLabel="title"/>
					</form:select>
        		</div>
			</div>
			<div class="control-group">
					<label for="status" class="control-label">Status</label>
					<div class="controls">
						<form:radiobutton path="bibleVerse.status" value="1" /> Yes  
						<form:radiobutton path="bibleVerse.status" value="0" /> No 
	        		</div>
			</div>
			<div class="control-group">
				<label for="description" class="control-label">Description</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${bibleVerse.description}</textarea>
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
