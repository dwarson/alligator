<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head></head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>Title：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>Link</th><th>Management</th></tr></thead>
		<tbody>
		<c:forEach items="${links}" var="link">
			<tr>
				<td><a href="${ctx}/link/update/${link.id}">${link.title}</a></td>
				<td><a href="${ctx}/link/delete/${link.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div><a class="btn" href="${ctx}/link/create">Create Link</a></div>
</body>
</html>
