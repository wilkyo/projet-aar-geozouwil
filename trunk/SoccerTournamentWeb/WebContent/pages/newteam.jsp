<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet" href="styles/base.css" />
<link type="text/css" rel="stylesheet" href="styles/form.css" />
<title>New Team</title>
</head>
<body>
	<div id="header">
		Nouvelle Equipe
	</div>	
	<div id="body">
		<p>
			<a href="?action=home">Home</a>
		</p>
		<form method="post" action="?action=ajout">
			<fieldset>
				<legend>
					Equipe
				</legend>
				<label id="labequipe">Nom de l'Equipe</label>
				<input type="text" id="nomequipe" name="nouveau"/>	
				<label id="labrep">Représentant</label>			
				<input type="text" class="nom" id="nomrep" placeholder="nom"/>
				<input type="text" class="prenom" id="prenomrep" placeholder="prenom"/>	
			</fieldset>
			<fieldset>
				<legend>
					Les joueurs
				</legend>
				<c:forEach begin="1" end="11" step="1" var="i">				
					<label for="nom${i}">Joueur ${i}</label>
					<input type="text" class="nom" id="nom${i}" name="nom[]" placeholder="nom"/>
					<input type="text" class="prenom" id="prenom" name="prenom[]" placeholder="prenom"/><br/>
				</c:forEach>
				<input type="submit" value="Ajout" />
			</fieldset>			
		</form>
	</div>
</body>
</html>