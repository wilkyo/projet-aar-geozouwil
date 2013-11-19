<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/custom.tld" prefix="custom"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<title>Home</title>
</head>
<body>
	<div id="header">Welcome!</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<div id="box">
			<%
				// <%=request.getAttribute(\"tournois\")% > == ${tournois}
			%>
			<div id="tournois">
				<c:forEach items="${tournois}" var="tournoi">
					<ul><li><a href="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_TOURNAMENT%>&id=${tournoi.nom}"><c:out value="${tournoi.nom}" /></a></li></ul>
				</c:forEach>
			</div>
			<!--<c:forEach items="${tournois}" var="tournoi">
				<custom:tournoi-diagramme tournoi="${tournoi}" />
				<c:out value="${tournoi.nom}" />
				<c:forEach items="${tournoi.rencontres}" var="rencontre">
					<jsp:useBean id="rencontre"
						class="com.soccer.valueobjects.VORencontreLight" scope="page" />
					<%=rencontre.getId()%>
					<br />
					<c:out value="${rencontre.id}" />
				</c:forEach>__<br />
			</c:forEach>-->
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>