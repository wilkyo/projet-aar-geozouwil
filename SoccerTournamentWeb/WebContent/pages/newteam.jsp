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
<title>New Team</title>
</head>
<body>
	<div id="header">Nouvelle Equipe</div>
	<div id="body">
		<p>
			<a href="?action=home">Home</a>
		</p>
		<form method="post" action="?action=<%=Controleur.ACTION_NEW_TEAM%>">
			<fieldset>
				<legend>
					Equipe
				</legend>
				<label id="labequipe">Nom de l'Equipe</label>
				<input type="text" id="nomequipe" name="nomEquipe" placeholder="Nom de l'Equipe" required="required"/>	
				<label id="labrep">Représentant</label>			
				<input type="text" class="nom" id="nomRepresentant" name="nomRepresentant"
					placeholder="Nom" />
				<input type="text" class="prenom" id="prenomRepresentant" name="prenomRepresentant"
					placeholder="Prénom" />
			</fieldset>
			<fieldset>
				<legend> Les joueurs </legend>
				<c:forEach begin="1" end="11" step="1" var="i">
					<label for="nom${i}">Joueur ${i}</label>
					<input type="text" class="numero" id="numero" name="numero[]"
						placeholder="N°" maxlength="2" width="5" />
					<input type="text" class="nom" id="nom${i}" name="nom[]"
						placeholder="Nom" />
					<input type="text" class="prenom" id="prenom" name="prenom[]"
						placeholder="Prénom" />
					<br />
				</c:forEach>
				<input type="submit" value="Ajout" />
			</fieldset>
		</form>
	</div>
</body>
</html>