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
	<form id="inputForm" action="${ctx}/pray/${action}" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${pray.id}" />
		<fieldset>
			<legend>
				<small>Pray Management</small>
			</legend>
			<div class="control-group">
				<label for="content" class="control-label">Pray Content:</label>
				<div class="controls">
					<input type="text" id="content" name="content"
						value="${pray.content}" class="input-large required" minlength="3" />
				</div>
			</div>
			<div class="control-group">
				<label for="pray_type" class="control-label">Pray Type</label>
				<div class="controls">
					<form:select path="pray.prayType.id">
						<form:option value="0" label="--- Select ---" />
						<form:options items="${prayTypes}" itemValue="id"
							itemLabel="title" />
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<label for="notes" class="control-label">Pray Notes</label>
				<div class="controls">
					<textarea id="notes" name="notes" class="input-large">${pray.notes}</textarea>
				</div>
			</div>
			<c:if test="${action== 'process'}">
				<div class="control-group">
					<label for="status" class="control-label">Is this Answered?</label>
					<div class="controls">
						<form:radiobutton path="pray.status" value="1" /> Yes  
						<form:radiobutton path="pray.status" value="0" /> No 
	        		</div>
				</div>
			</c:if>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit"
					value="Submit" />&nbsp; <input id="cancel_btn" class="btn"
					type="button" value="Retrun" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
</body>
</html>
