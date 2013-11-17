<%@page import="com.soccer.model.But"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.soccer.valueobjects.VORencontre"%>
<%
	boolean logged = session.getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="<%=Controleur.WEB_PATH + Controleur.CSS_PATH%>jquery-ui.css" />
	<link rel="stylesheet" href="<%=Controleur.WEB_PATH + Controleur.CSS_PATH%>jquery.ui.timepicker.css" />
	<link type="text/css" rel="stylesheet"
		href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
	<link type="text/css" rel="stylesheet"
		href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
	<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>buts.js"></script>
	<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery-1.9.1.js"></script>
	<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery-ui.js"></script>
	<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery.ui.datepicker-fr.js"></script>
	<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery.ui.timepicker.js"></script>
	<title>Édition de Rencontre</title>
</head>
<body>
	<div id="header">Édition de Rencontre</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TOURNAMENT %>&id=${rencontre.nomTournoi}">${rencontre.nomTournoi}</a>,
		tour ${rencontre.tour}<br /> Hôtes: <a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM %>&id=${rencontre.hotes.nom}">${rencontre.hotes.nom}</a><br />
		Visiteurs: <a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM %>&id=${rencontre.visiteurs.nom}">${rencontre.visiteurs.nom}</a>
		<form method="post"
			action="<%=Controleur.SERVLET_PATH + Controleur.ACTION_ADMIN_MATCH%>&id=<%=request.getParameter("id")%>">
			<jsp:useBean id="rencontre" class="com.soccer.valueobjects.VORencontre" scope="request" />
			<fieldset>
				<legend>Rencontre</legend>
				<%
					Calendar debut = rencontre.getDebut(), fin = rencontre.getFin();
					String dDebut = "", hDebut = "";
					if (debut != null) {
						dDebut = Controleur.formatDate(debut);
						hDebut = Controleur.formatHour(debut);
					}
					String hFin = "";
					if (fin != null) {
						hFin = Controleur.formatHour(fin);
					}
					boolean nonValidable = dDebut.equals("") && hDebut.equals("")
							|| rencontre.getButsHotes().size() == rencontre.getButsVisiteurs().size();
				%>
				<label for="debutD">Date du match</label>
				<input type="text" id="debutD" name="debutD" value="<%=dDebut%>" /><br />
				<label for="debutH">Heure du match</label>
				<input type="text" id="debutH" name="debutH" value="<%=hDebut%>" /><br />
				<label for="fin">Heure de fin</label>
				<input type="text" id="fin" name="fin" value="<%=hFin%>"<%=nonValidable ? " disabled=\"disabled\"" : "" %> /><br />
				<label for="arbitre">Arbitre</label>
				<select id="arbitre" name="arbitre">
					<option value="0">--</option>
					<c:forEach items="${arbitres}" var="arbitre">
						<option value="${arbitre.id}"<c:if test="${arbitre.id == rencontre.arbitre.id}"> selected="selected"</c:if>>${arbitre.prenom}
							${arbitre.nom}</option>
					</c:forEach>
				</select><br />
				<input type="submit" value="Sauvegarder" />
			</fieldset>
		</form>
		<form id="buts" method="post" action="<%=Controleur.SERVLET_PATH + Controleur.ACTION_NEW_BUT%>&id=<%=request.getParameter("id")%>">
			<fieldset>
				<legend>Buts</legend>
				<div class="left">
					<c:forEach items="<%=rencontre.getButsHotes()%>" var="butH">
						<jsp:useBean id="butH" class="com.soccer.valueobjects.VOBut" scope="page" />
						<%=butH.getAuteur().getPrenom() + " " + butH.getAuteur().getNom()%> à <%=Controleur.formatHour(butH.getHeure())%><br />
					</c:forEach>
				</div>
				<div class="right">
					<c:forEach items="<%=rencontre.getButsVisiteurs()%>" var="butV">
						<jsp:useBean id="butV" class="com.soccer.valueobjects.VOBut" scope="page" />
						<%=butV.getAuteur().getPrenom() + " " + butV.getAuteur().getNom()%> à <%=Controleur.formatHour(butV.getHeure())%><br />
					</c:forEach>
				</div>
				<div class="clear"></div>
				<label for="butEquipe">Nouveau but</label><br />
				<select id="butEquipe" onChange="getJoueurs();">
					<option value="--">--</option>
					<option value="<%=rencontre.getHotes().getNom()%>"><c:out value="<%=rencontre.getHotes().getNom()%>" /></option>
					<option value="<%=rencontre.getVisiteurs().getNom()%>"><c:out value="<%=rencontre.getVisiteurs().getNom()%>" /></option>
				</select>
				<select id="butJoueur" name="butJoueur">
				</select><br />
				<label for="butHeure">Heure du but</label>
				<input type="text" id="butHeure" name="butHeure" /><br />
				<input type="submit" value="Ajouter But" />
			</fieldset>
		</form>
	</div>
	<jsp:include page="../includes/footer.jsp" />
	<script type="text/javascript">
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional[""]);
			$("#debutD").datepicker($.datepicker.regional["fr"]);
			$("#debutH").timepicker();
			$("#butHeure").timepicker();
			$("#fin").timepicker();
		});
		if(document.getElementById("debutD").value != '')
			document.getElementById("buts").style.display = 'block';
	</script>
</body>
</html>