<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="checkCred" method="post">
		<pre>
			User Name or Email : <input type="text" name="userName"/>
			Password : <input type="password" name="password"/>
			<input type="submit" value="Login"/>
		</pre>
	</form>
	${msg}
</body>
</html>