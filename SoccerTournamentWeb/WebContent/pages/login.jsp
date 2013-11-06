<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet" href="styles/base.css" />
<link type="text/css" rel="stylesheet" href="styles/form.css" />
<title>Login</title>
</head>
<body>
	<div id="header">
		Login to Soccer Tournament
	</div>
	<div id="body">
		<p>
			<a href="?action=home">Home</a>
		</p>
		<form action="?action=login" method="post">
			<fieldset>
				<legend>Connexion</legend>
				<input type="text" id="login" name="login" placeholder="Login" required="required" /><br />
				<input type="password" id="pass" name="password" placeholder="Password" required="required" /><br />
				<input type="submit" value="Se connecter" />
			</fieldset>
		</form>
	</div>
</body>
</html>