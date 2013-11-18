<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.soccer.valueobjects.VORencontre"%>
<%@ page import="com.soccer.valueobjects.VOBut"%>
<%@ page import="com.soccer.model.Arbitre"%>
<%
	boolean logged = request.getSession().getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Rencontre</title>
</head>
<body>
	<div id="header">Rencontre</div>
	<jsp:include page="../includes/menu.jsp" />

	<div id="body">
		<h3>
			<a
				href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TOURNAMENT%>&id=${rencontre.nomTournoi}">${rencontre.nomTournoi}</a>
			<br /> Tour ${rencontre.tour}
		</h3>

		<jsp:useBean id="rencontre"
			class="com.soccer.valueobjects.VORencontre" scope="request" />
		<%
			Calendar debut = rencontre.getDebut(), fin = rencontre.getFin();
			String dateDebut = "", dateFin = "", heureDebut = "", heureFin = "";
			boolean prolongation = false, tab = false, encours = false;

			int nbButsHotes = rencontre.getButsHotes().size();
			int nbButsVisiteurs = rencontre.getButsVisiteurs().size();

			if (debut != null) {
				dateDebut = Controleur.formatDate(debut);
				heureDebut = Controleur.formatHour(debut);
			}
			if (fin != null) {
				dateFin = Controleur.formatDate(fin);
				heureFin = Controleur.formatHour(fin);
			}
			if (debut != null && fin != null) {
				int dureeMatch = Controleur.getIntervalleDate(debut, fin);
				if (dureeMatch > 90 && dureeMatch <= 120) {
					prolongation = true;
				} else if (dureeMatch > 120) {
					prolongation = true;
					tab = true;
				}
			}

			Arbitre arbitre = rencontre.getArbitre();
			String nom = "", prenom = "";
			if (arbitre != null) {
				nom = rencontre.getArbitre().getNom();
				prenom = rencontre.getArbitre().getPrenom();
			}

			if (debut != null) {
				encours = debut.before(Calendar.getInstance());
			}
		%>

		<div id="entete">
			<ol>
				<li>
					<h3>${rencontre.hotes.nom} - ${rencontre.visiteurs.nom}</h3>
				</li>
				<li><h3><%=encours || fin != null ? nbButsHotes + " - "
					+ nbButsVisiteurs : ""%>
					</h3></li>
				<li><h3><%=prolongation ? "Prolongation" : ""%></h3></li>
				<li><h3><%=tab ? "Tirs aux buts" : ""%></h3></li>
			</ol>
		</div>

		<p>
			Arbitre :<%=arbitre == null ? " Non défini" : " " + prenom + " "
					+ nom%>
		</p>
		<p>
			Début :<%=dateDebut.equals("") ? " Non définie" : " Le "
					+ dateDebut + " à " + heureDebut%>
		</p>
		<p>
			Fin :<%=dateFin.equals("") ? " Non définie" : " Le " + dateFin
					+ " à " + heureFin%>
		</p>

		<div id="bloc_vs">

			<div id="bloc_vs_left">
				<h4>${rencontre.hotes.nom}</h4>
				<h4>${rencontre.hotes.prenomRepresentant}
					${rencontre.hotes.nomRepresentant}</h4>
				<c:forEach items="${rencontre.hotes.joueurs}" var="joueur">
					<ol>
						<li>${joueur.numero} - ${joueur.prenom} ${joueur.nom}</li>
					</ol>
				</c:forEach>
			</div>

			<div id="bloc_vs_right">
				<h4>${rencontre.visiteurs.nom}</h4>
				<h4>${rencontre.visiteurs.prenomRepresentant}
					${rencontre.visiteurs.nomRepresentant}</h4>
				<c:forEach items="${rencontre.visiteurs.joueurs}" var="joueur">
					<ol>
						<li>${joueur.numero} - ${joueur.prenom} ${joueur.nom}</li>
					</ol>
				</c:forEach>
			</div>

			<div id="buts">
				<h4>
					Faits du match
					<%=encours && fin == null ? " (Match en cours)" : ""%>
					<%=!encours && fin == null ? " (Match à venir)" : ""%>
					<%=fin != null ? " (Match terminé)" : ""%>
				</h4>
				<c:if test="<%=encours || fin != null%>">
					<ol>
						<li>0' <img id="imSifflet" width="25" height="25"
							src="images/sifflet.png" /> L'arbitre du match
							${rencontre.arbitre.prenom} ${rencontre.arbitre.nom} lance la
							rencontre.
						</li>
					</ol>
					<c:forEach
						items="<%=Controleur.getButsAvantProlongation(rencontre
							.getDebut(), Controleur.trierButs(
							rencontre.getButsHotes(),
							rencontre.getButsVisiteurs()))%>"
						var="butsAvantP">
						<jsp:useBean id="butsAvantP" class="com.soccer.valueobjects.VOBut"
							scope="page" />
						<ol>
							<li>
								<%
									int MinuteBut = Controleur.getIntervalleDate(debut,
													butsAvantP.getHeure());
								%> <c:out value="<%=MinuteBut%>" /> ' <img id="imBallon"
								width="25" height="25" src="images/ballon.png" />
								${butsAvantP.auteur.prenom} ${butsAvantP.auteur.nom} inscrit un
								but pour ${butsAvantP.auteur.nomEquipe}.
							</li>
						</ol>
					</c:forEach>
					<c:if test="<%=fin != null && !prolongation%>">
						<ol>
							<li>90' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> L'arbitre siffle la fin de la
								rencontre.
							</li>
						</ol>
					</c:if>
					<c:if test="<%=fin != null && prolongation%>">
						<ol>
							<li>90' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> A l'issu du temps réglementaire,
								les deux équipes ne se sont pas départagées. L'arbitre siffle
								donc le début de la prolongation.
							</li>
						</ol>
					</c:if>
					<c:forEach
						items="<%=Controleur.getButsApresProlongation(rencontre
							.getDebut(), Controleur.trierButs(
							rencontre.getButsHotes(),
							rencontre.getButsVisiteurs()))%>"
						var="butsApresP">
						<jsp:useBean id="butsApresP" class="com.soccer.valueobjects.VOBut"
							scope="page" />
						<ol>
							<li>
								<%
									int MinuteBut = Controleur.getIntervalleDate(debut,
													butsApresP.getHeure());
								%> <c:out value="<%=MinuteBut%>" /> ' <img id="imBallon"
								width="25" height="25" src="images/ballon.png" />
								${butsApresP.auteur.prenom} ${butsApresP.auteur.nom} inscrit un
								but pour ${butsApresP.auteur.nomEquipe}.
							</li>
						</ol>
					</c:forEach>
					<c:if test="<%=fin != null && tab%>">
						<ol>
							<li>120' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> Les deux équipes sont encore à
								égalité à l'issu de la prolongation. L'arbitre lance donc
								les tirs aux buts.
							</li>
						</ol>
					</c:if>
				</c:if>
			</div>

		</div>
		<div class="clear"></div>

	</div>

	<jsp:include page="../includes/footer.jsp" />
</body>
</html>