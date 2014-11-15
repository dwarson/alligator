<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Account Setting</title>
</head>
<body>
<h2>Account Information:</h2>
	<sf:form method="POST" modelAttribute="user" action="/user">
		<fieldset>
			<legend>Profile</legend>
			<div>
				<label for="user_full_name">Full Name:</label>
				${user.name}
				<sf:errors path="name"/>
			</div>
		</fieldset>
	</sf:form>
</body>
</html>
