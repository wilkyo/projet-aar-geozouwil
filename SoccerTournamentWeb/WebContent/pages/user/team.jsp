<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	boolean logged = request.getSession().getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Équipe<%=request.getParameter("id") == null ? "s" : ""%></title>
</head>
<body>
	<div id="header">
		Équipe<%=request.getParameter("id") == null ? "s" : ""%></div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<c:if test="${equipe != null}">
			<!-- Une équipe -->
			${equipe.nom}<br />
			<c:forEach items="${equipe.joueurs}" var="joueur">
				${joueur.prenom} ${joueur.nom}<br />
			</c:forEach>
		</c:if>
		<c:if test="${equipes != null}">
			<!-- Les équipes -->
			<c:forEach items="${equipes}" var="equipe">
				<a
					href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM%>&id=${equipe.nom}">${equipe.nom}</a>
				<br />
			</c:forEach>
		</c:if>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>