<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head></head>
<body>
	<c:forEach var="link" items="${links}">
	  	<h5>${link.key}</h5>
	  	<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<tbody>
				<tr>
					<c:forEach items="${link.value}" var="element">
						<td><a href="${element.url}" target="_blank">${element.title}</a></td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>
