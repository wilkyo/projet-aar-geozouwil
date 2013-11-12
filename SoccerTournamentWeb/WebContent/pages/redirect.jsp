<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Refresh"
	content="0;url=<%=Controleur.SERVLET_PATH%>${redirect}">
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Redirect</title>
</head>
<body>
	<div id="header"></div>
	<jsp:include page="includes/menu.jsp" />
	<div id="body"></div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>