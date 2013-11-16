<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	boolean logged = session.getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Édition de Rencontre</title>
</head>
<body>
	<div id="header">Édition de Rencontre</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		Tournoi: <a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TOURNAMENT %>&id=${rencontre.nomTournoi}">${rencontre.nomTournoi}</a><br />
		Hôtes: <a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM %>&id=${rencontre.hotes.nom}">${rencontre.hotes.nom}</a><br />
		Visiteurs: <a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM %>&id=${rencontre.visiteurs.nom}">${rencontre.visiteurs.nom}</a>
		<form method="post" 
			action="<%=Controleur.SERVLET_PATH + Controleur.ACTION_ADMIN_MATCH%>&id=${rencontre.hotes.nom}">
			<label for="arbitre">Arbitre</label>
			<select id="arbitre" name="arbitre">
				<option value="0">--</option>
				<c:forEach items="${arbitres}" var="arbitre">
					<option value="${arbitre.id}">${arbitre.prenom}
						${arbitre.nom}</option>
				</c:forEach>
			</select><br />
			<input type="submit" value="Modifier" />
		</form>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>