<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
</head>
<body>
	<p>
		<a href="pages/home.html">Home</a>
	</p>
	<center>
		<h3>Login to Soccer Tournement</h3>
	</center>
	<form action="connect">
		<table align="center">
			<tr>
				<td>Login</td>
				<td><input type="text" name="login"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" name="validate" /><input
					type="submit" value="validate" /></td>

			</tr>
		</table>
	</form>
</body>
</html>