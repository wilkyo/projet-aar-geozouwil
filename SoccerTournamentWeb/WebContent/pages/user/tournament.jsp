<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/custom.tld" prefix="custom"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	boolean logged = session.getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<title>Home</title>
</head>
<body>
	<div id="header"><%=request.getParameter("id")%></div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<div  id="coupe"><img alt="" src="images/coupe.png"></div>
		<custom:tournoi-diagramme tournoi="${tournoi}" admin="<%=logged%>" />
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>