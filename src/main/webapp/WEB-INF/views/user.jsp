<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Account Setting</title>
</head>
<body>
<h2>Account Setting</h2>
	<sf:form method="POST" modelAttribute="user" action="/user">
		<fieldset>
			<legend>Profile</legend>
			<div>
				<label for="user_full_name">Full Name:</label>
				<sf:input path="username" size="15" id="user_full_name"/>
				<sf:errors path="username"/>
			</div>
		    <input type="submit" value="Save account">	
		</fieldset>
	</sf:form>
</body>
</html>
