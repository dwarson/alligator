<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>404 - Page does not exist.</title>
</head>

<body>
	<h2>404 - Page does not exist..</h2>
	<p><a href="<c:url value="/"/>">Return to Home page</a></p>
</body>
</html>