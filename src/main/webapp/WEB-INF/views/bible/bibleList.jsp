<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head></head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<c:forEach items="${bibleBooks}" var="bibleBook">
	<h5>${bibleBook.title}</h5>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<tbody>
				 <tr><td>
					<c:forEach items="${bibleBook.chapters}" var="chapter">
	                    <a href="${ctx}/bible/read/${chapter.id}" <c:if test="${chapter.status =='1'}">style="background-color:#67BCDB"</c:if>>
	                    ${chapter.title}
	                    </a>
					</c:forEach>
				</td></tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>
