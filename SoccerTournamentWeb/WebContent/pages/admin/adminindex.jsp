<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/custom.tld" prefix="custom"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_FORM)%>" />
	<title>Accueil Admin</title>
</head>
<body>
	<div id="header">Administration</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<div id="tournois">
			<c:forEach items="${tournois}" var="tournoi">
				<ul><li><a
					href="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_TOURNAMENT%>&id=${tournoi.nom}"><c:out
						value="${tournoi.nom}" /></a></li></ul>
			</c:forEach>
		</div>
		<c:set var="nbEquipes" value="${equipes.size()}" />
		<jsp:useBean id="nbEquipes" type="java.lang.Integer" scope="page" />
		<%
			if (nbEquipes == null)
				nbEquipes = 0;
			boolean nbEquipesCorrect = Integer.lowestOneBit(nbEquipes) == nbEquipes;
		%>
		<c:if test="<%=nbEquipesCorrect%>">
			<form method="post"
				action="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_CREATE_TOURNAMENT%>">
				<fieldset>
					<legend>Création du Tournoi</legend>
					<label for="nom">Nom du Tournoi</label> 
					<input type="text" class="nom" id="nom"
						name="nom" placeholder="Nom du Tournoi" required="required" /><br />
					<input  type="submit" value="Créer Tournoi" />
				</fieldset>
			</form>
		</c:if>
		<c:if test="<%=!nbEquipesCorrect%>">
			Le tournoi ne peut pas être créé car le nombre d'équipes n'est pas une puissance de deux.
		</c:if>

		<!--  Ajouter un arbitre  -->
		<form method="post"
			action="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_NEW_REFEREE%>">
			<fieldset>
				<legend>Ajout d'un arbitre</legend>
				<input type="text" class="nom" id="nomReferee" name="nomReferee"
					placeholder="Nom" required="required" /><br /> 
				<input type="text" class="prenom"
					id="prenomReferee" name="prenomReferee" placeholder="Prénom"
					required="required" /><br /> 
				<input type="submit"
					value="Ajouter arbitre" />
			</fieldset>
		</form>
		
		<!-- Listes des équipes -->
		<div id="equipes">
			<c:forEach items="${equipes}" var="equipe">
				<c:out value="${equipe.nom}" />
				
			</c:forEach>
		</div>
		<br />
		<!-- Listes des arbitres -->
		<div id="arbitres">
			<c:forEach items="${arbitres}" var="arbitre">
				<c:out value="${arbitre.nom} ${arbitre.prenom}" />
				
			</c:forEach>
		</div>
		
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>