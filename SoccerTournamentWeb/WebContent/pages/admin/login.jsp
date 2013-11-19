<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>form.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Login</title>
</head>
<body>
	<div id="header">
		Login to Soccer Tournament
	</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body" >
		<c:if test="${error}">
			<span class="error">Mauvais login ou mot de passe !</span>
		</c:if>
		<form action="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_LOGIN%>" method="post">
			<fieldset class="body-login">
				<legend>Connexion</legend>
				<input type="text" id="login" name="login" placeholder="Login" required="required" /><br />
				<input type="password" id="pass" name="password" placeholder="Password" required="required" /><br />
				<input type="submit" value="Se connecter" />
			</fieldset>
		</form>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>