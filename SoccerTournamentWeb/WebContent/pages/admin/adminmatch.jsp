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
<link rel="stylesheet"
	href="<%=Controleur.WEB_PATH + Controleur.CSS_PATH%>jquery-ui.css" />
<link rel="stylesheet"
	href="<%=Controleur.WEB_PATH + Controleur.CSS_PATH%>jquery.ui.timepicker.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_FORM)%>" />
<script src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>buts.js"></script>
<script
	src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery-1.9.1.js"></script>
<script
	src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery-ui.js"></script>
<script
	src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery.ui.datepicker-fr.js"></script>
<script
	src="<%=Controleur.WEB_PATH + Controleur.SCRIPTS_PATH%>jquery.ui.timepicker.js"></script>
<title>Édition de Rencontre</title>
</head>
<body>
	<div id="header">Édition de Rencontre</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<jsp:useBean id="rencontre"
			class="com.soccer.valueobjects.VORencontre" scope="request" />
		<c:if test="<%=rencontre.getFin() == null%>">
			<a
				href="<%=Controleur.SERVLET_PATH
						+ Controleur.ACTION_TOURNAMENT%>&id=<%=rencontre.getNomTournoi()%>"><%=rencontre.getNomTournoi()%></a>,
			tour ${rencontre.tour}<br /> Hôtes: <a
				href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM%>&id=<%=rencontre.getHotes().getNom()%>"><%=rencontre.getHotes().getNom()%></a>
			<br />
			Visiteurs: <a
				href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM%>&id=<%=rencontre.getVisiteurs().getNom()%>"><%=rencontre.getVisiteurs().getNom()%></a>
			<form method="post"
				action="<%=Controleur.SERVLET_PATH
						+ Controleur.ACTION_ADMIN_MATCH%>&id=<%=request.getParameter("id")%>">
				<fieldset>
					<legend>Rencontre</legend>
					<%
						Calendar debut = rencontre.getDebut(), fin = rencontre.getFin();
							String dDebut = "", hDebut = "";
							boolean encours = false;
							if (debut != null) {
								dDebut = Controleur.formatDate(debut);
								hDebut = Controleur.formatHour(debut);
								encours = debut.before(Calendar.getInstance());
							}
							String hFin = "";
							if (fin != null) {
								hFin = Controleur.formatHour(fin);
							}
							boolean nonValidable = dDebut.equals("")
									&& hDebut.equals("")
									|| rencontre.getButsHotes().size() == rencontre
											.getButsVisiteurs().size();
					%>
					<label for="debutD">Date du match</label>
					<input type="text" class="date" id="debutD" name="debutD" value="<%=dDebut%>" required="required" /><br />
					<label for="debutH">Heure du match</label>
					<input type="text" class="date" id="debutH" name="debutH" value="<%=hDebut%>" required="required" /><br />
					<label for="arbitre">Arbitre</label>
					<select id="arbitre" class="liste-arbitre" name="arbitre">
						<option value="0">--</option>
					<c:forEach items="${arbitres}" var="arbitre">
						<option value="${arbitre.id}"
							<c:if test="${arbitre.id == rencontre.arbitre.id}"> selected="selected"</c:if>>${arbitre.prenom}
							${arbitre.nom}</option>
					</c:forEach>
					</select><br />
					<input type="submit" value="Sauvegarder" />
				</fieldset>
			</form>
			<c:if test="<%=encours && rencontre.getArbitre() != null%>">
				<form id="buts" method="post"
					action="<%=Controleur.SERVLET_PATH
							+ Controleur.ACTION_NEW_BUT%>&id=<%=request.getParameter("id")%>">
					<fieldset>
						<legend>Buts</legend>
						<div class="left">
							<c:forEach items="<%=rencontre.getButsHotes()%>" var="butH">
								<jsp:useBean id="butH" class="com.soccer.valueobjects.VOBut"
									scope="page" />
								<%=butH.getAuteur().getPrenom() + " "
								+ butH.getAuteur().getNom()%> à <%=Controleur.formatHour(butH.getHeure())%><br />
							</c:forEach>
						</div>
						<div class="right">
							<c:forEach items="<%=rencontre.getButsVisiteurs()%>" var="butV">
								<jsp:useBean id="butV" class="com.soccer.valueobjects.VOBut"
									scope="page" />
								<%=butV.getAuteur().getPrenom() + " "
								+ butV.getAuteur().getNom()%> à <%=Controleur.formatHour(butV.getHeure())%><br />
							</c:forEach>
						</div>
						<div class="clear"></div>
						<label for="butEquipe">Nouveau but</label><br />
						<select id="butEquipe" class="nouveau-but" onChange="getJoueurs();">
							<option value="--">--</option>
							<option value="<%=rencontre.getHotes().getNom()%>"><c:out
									value="<%=rencontre.getHotes().getNom()%>" /></option>
							<option value="<%=rencontre.getVisiteurs().getNom()%>"><c:out
									value="<%=rencontre.getVisiteurs().getNom()%>" /></option>
						</select>
						<select id="butJoueur" class="nouveau-but" name="butJoueur" style="display: none;">
						</select><br />
						<label for="butHeure">Heure du but</label>
						<input type="text" class="heure" id="butHeure" name="butHeure" required="required" /><br />
						<input type="submit" value="Ajouter But" />
					</fieldset>
				</form>
			</c:if>
			<c:if test="<%=!nonValidable%>">
				<form method="post"
					action="<%=Controleur.SERVLET_PATH
							+ Controleur.ACTION_VALIDATE_MATCH%>&id=<%=request.getParameter("id")%>"
							onsubmit="return confirm('Voulez vous vraiment valider la rencontre ?\nCeci empêchera toute modification.');">
					<fieldset>
						<legend>Valider Rencontre</legend>
						<input type="submit" value="Valider" />
					</fieldset>
				</form>
			</c:if>
		</c:if>
		<c:if test="<%=rencontre.getFin() != null%>">
			<span class="erreur">La rencontre a déjà été validée !</span>
		</c:if>
	</div>
	<jsp:include page="../includes/footer.jsp" />
	<script type="text/javascript">
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional[""]);
			$("#debutD").datepicker($.datepicker.regional["fr"]);
			$("#debutH").timepicker();
		});
	</script>
</body>
</html>