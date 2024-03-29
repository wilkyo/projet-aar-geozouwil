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
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<title>Équipe<%=request.getParameter("id") == null ? "s" : ""%></title>
</head>
<body>
	<div id="header">
		Équipe<%=request.getParameter("id") == null ? "s" : ""%></div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<c:if test="${equipe != null}">
			<!-- Une équipe -->
			<h4>${equipe.nom}</h4>
			<h4>${equipe.prenomRepresentant} ${equipe.nomRepresentant}</h4>
			<c:forEach items="${equipe.joueurs}" var="joueur">
				<ol class="rounded-list"><li>${joueur.numero} - ${joueur.prenom} ${joueur.nom}</li></ol>
			</c:forEach>
		</c:if>
		<c:if test="${equipes != null}">
			<!-- Les équipes -->
			<c:forEach items="${equipes}" var="equipe">
				<ol class="rectangle-list"><li><a href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM%>&id=${equipe.nom}">${equipe.nom}</a></li></ol>
			</c:forEach>
		</c:if>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>