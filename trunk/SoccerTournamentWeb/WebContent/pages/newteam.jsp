<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
		<form action="">
			<fieldset>
				<legend>
					Nom de l'Equipe
				</legend>
				<label id="labequipe">Equipe</label>
				<input type="text" id="nomequipe" name="nouveau"/>				
			</fieldset>
			<fieldset>
				<legend>
					Les joueurs
				</legend>
				<c:forEach begin="1" end="11" step="1" var="i">				
					<label>Joueur ${i}</label>
					<input type="text" id="nom" name="nom${i}" placeholder="nom"/>
					<input type="text" id="prenom" name="prenom${i}" placeholder="prenom"/><br/>
				</c:forEach>
				<input type="submit" value="Ajout" />
			</fieldset>			
		</form>
	</div>
</body>
</html>