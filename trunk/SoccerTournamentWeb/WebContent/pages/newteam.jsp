<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_FORM)%>" />
	<title>New Team</title>
		<script type="text/javascript">
			function add_player() {
				var elt = document.getElementById('player_' + (last_player_id));
				elt.style.display = 'block';
				if(last_player_id >= 15) {
					document.getElementById('boutonAdd').style.display = 'none';
				} else {
					elt.outerHTML += '<div style="display:none;" id="player_' + (++last_player_id) + '">' +
								'<label for="nom' + last_player_id + '">Joueur ' + last_player_id + '</label><br/>' +
								'<input type="text" class="numero" id="numero' + last_player_id + '" name="numero[]" placeholder="N°" maxlength="2" width="5" />' +
								'<input type="text" class="prenom" id="prenom' + last_player_id + '" name="prenom[]" placeholder="Prénom" />' +
								'<input type="text" class="nom" id="nom' + last_player_id + '" name="nom[]" placeholder="Nom" />'
							'</div>';
				}
			}
		</script>
</head>
<body>
	<div id="header">Nouvelle Equipe</div>
	<jsp:include page="includes/menu.jsp" />
	<div id="body">
		<div id="box">
			<form method="post" action="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_NEW_TEAM%>">
				<fieldset>
					<legend> Equipe </legend>
					<label id="labequipe">Nom de l'Equipe</label>
					<input type="text"
						id="nomEquipe" name="nomEquipe" placeholder="Nom de l'Equipe"
						required="required" value="${nomEquipe}" />
					<c:if test="${exists}"><br />
						<span class="error">Ce nom d'équipe est déjà pris !</span>
					</c:if>
					<c:if test="${notEnough}"><br />
						<span class="error">Il faut au moins 11 joueurs !</span>
					</c:if>
					<label id="labrep">Représentant</label>  
					<input type="text" class="prenom"
						id="prenomRepresentant" name="prenomRepresentant"
						placeholder="Prénom" value="${prenomRepresentant}" />
					<input type="text"
						class="nom" id="nomRepresentant" name="nomRepresentant"
						placeholder="Nom" value="${nomRepresentant}" />
				</fieldset>
				<fieldset>
					<legend> Les joueurs </legend>
					<c:forEach begin="1" end="11" step="1" var="i">
						<c:set var="cpt_players" value="${i + 1}" />
						<label for="nom${i}">Joueur ${i}</label><br/>
						<input type="text" class="numero" id="numero${i}" name="numero[]"
							placeholder="N°" maxlength="2" width="5" value="${numero[i - 1]}" />
						<input type="text" class="prenom" id="prenom${i}" name="prenom[]"
							placeholder="Prénom" value="${prenom[i - 1]}" />
						<input type="text" class="nom" id="nom${i}" name="nom[]"
							placeholder="Nom" value="${nom[i - 1]}" />
						
						<br />
					</c:forEach>
					<div style="display:none;" id="player_${cpt_players}">
						<label for="nom${cpt_players}">Joueur ${cpt_players}</label><br/>
						<input type="text" class="numero" id="numero${cpt_players}" name="numero[]"
							placeholder="N°" maxlength="2" width="5" />
						<input type="text" class="prenom" id="prenom${cpt_players}" name="prenom[]"
							placeholder="Prénom" />
						<input type="text" class="nom" id="nom${cpt_players}" name="nom[]"
							placeholder="Nom" />
					</div>
					<input type="button" id="boutonAdd" onclick="add_player();" value="Ajouter Joueur" /><br />
					<input type="submit" value="Créer Équipe" />
				</fieldset>
			</form>
			<script type="text/javascript">
				var last_player_id = ${cpt_players};
			</script>
			<c:if test="${exists}">
			<script type="text/javascript">
				var elt = document.getElementById("nomEquipe");
				elt.value = '<%=request.getParameter("nomEquipe")%>';
			</script>
			</c:if>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>