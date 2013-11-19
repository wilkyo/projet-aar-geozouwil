<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<title>404</title>
</head>
<body>
	<div id="header"></div>
	<jsp:include page="includes/menu.jsp" />
	<div id="body">
		<div id="_404" class="error">Page not found.</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>