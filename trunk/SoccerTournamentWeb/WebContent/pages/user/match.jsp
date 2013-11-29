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
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
	<link type="text/css" rel="stylesheet" href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
	<title>Rencontre</title>
</head>
<body>
	<div id="header">Rencontre</div>
	<jsp:include page="../includes/menu.jsp" />

<!-- Début body -->

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

			String nomHotes = rencontre.getHotes().getNom();
			String nomVisiteurs = rencontre.getVisiteurs().getNom();
			int nbButsHotes = 0;
			int nbButsVisiteurs = 0;
			int nbButsHotesTAB = 0;
			int nbButsVisiteursTAB = 0;

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

			if (debut != null) {
				encours = debut.before(Calendar.getInstance());
			}
			
			if(encours) {
				nbButsHotes = Controleur.scoreHorsTAB(debut, rencontre.getButsHotes());
				nbButsVisiteurs = Controleur.scoreHorsTAB(debut, rencontre.getButsVisiteurs());
			}
		
			if(tab) {
				nbButsHotesTAB = Controleur.scoreTAB(debut, rencontre.getButsHotes());
				nbButsVisiteursTAB = Controleur.scoreTAB(debut, rencontre.getButsVisiteurs());
			}
			
			Arbitre arbitre = rencontre.getArbitre();
			String nom = "", prenom = "";
			if (arbitre != null) {
				nom = rencontre.getArbitre().getNom();
				prenom = rencontre.getArbitre().getPrenom();
			}

			
		%>
		
<!--  Début entete  -->

		<div id="entete">
			<ol>
				<li>
					<h3>${rencontre.hotes.nom} - ${rencontre.visiteurs.nom}</h3>
				</li>
				<li><h3><%=encours || fin != null ? nbButsHotes + " - "
					+ nbButsVisiteurs : ""%>
					</h3></li>
				<li><h3><%=prolongation ? "Prolongation" : ""%></h3></li>
				<li><h3><%=tab ? "Tirs aux buts (" + nbButsHotesTAB + " - " + nbButsVisiteursTAB + ")" : ""%></h3></li>
			</ol>
		</div>
		
<!-- Fin entete -->

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

<!--  Début bloc_vs -->

		<div id="bloc_vs">

	<!-- Début bloc gauche -->

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
			
	<!-- Fin bloc gauche  -->

	<!--  Début bloc droite -->

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
			
	<!-- Fin bloc droite -->

	<!-- Début buts -->
	
			<div id="buts">
				<h4>
					Faits du match
					<%=encours && fin == null ? " (Match en cours)" : ""%>
					<%=!encours && fin == null ? " (Match à venir)" : ""%>
					<%=fin != null ? " (Match terminé)" : ""%>
				</h4>
				<c:if test="<%=encours || fin != null%>">
					<ol>
						<li> <c:out value="<%=Controleur.getIntervalleDate(debut,debut)%>"/> ' 					
							 <img id="imSifflet" width="25" height="25" src="images/sifflet.png" /> 
						L'arbitre du match ${rencontre.arbitre.prenom} ${rencontre.arbitre.nom} lance la rencontre.
						</li>
						
						<!-- affiche tous les buts marqués avant la prolongation -->
						<c:forEach
							items="<%=Controleur.getButsAvantProlongation(rencontre
								.getDebut(), Controleur.trierButs(
								rencontre.getButsHotes(),
								rencontre.getButsVisiteurs()))%>" var="butsAvantP">
							<jsp:useBean id="butsAvantP" class="com.soccer.valueobjects.VOBut"
								scope="page" />
							<li> <c:out value="<%=Controleur.getIntervalleDate(debut,butsAvantP.getHeure())%>" /> ' 
								 <img id="imBallon" width="25" height="25" src="images/ballon.png" />
								${butsAvantP.auteur.prenom} ${butsAvantP.auteur.nom} inscrit un but pour ${butsAvantP.auteur.nomEquipe}.
							</li>
						</c:forEach>
						
						<!-- si le match se termine sans prolongation -->
						<c:if test="<%=fin != null && !prolongation%>">
							<li>90 ' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> L'arbitre siffle la fin de la
								rencontre.
							</li>
							<li> <%=rencontre.getButsHotes().size() > rencontre.getButsVisiteurs().size() ? 
									"L'équipe de " + nomHotes + " remporte la rencontre." :
									"L'équipe de " + nomVisiteurs + " remporte la rencontre."%>
							</li>
						</c:if>
						
						<!-- si le match se termine avec prolongation -->
						<c:if test="<%=fin != null && prolongation%>">
							<li>90 ' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> Les deux équipes ont besoin d'une prolongation pour se départager.
							</li>
							
						<!-- on affiche tous les buts marqués pendant la prolongation -->
						<c:forEach
							items="<%=Controleur.getButsPendantProlongation(rencontre
								.getDebut(), Controleur.trierButs(
								rencontre.getButsHotes(),
								rencontre.getButsVisiteurs()))%>"
							var="butsPendantP">
							<jsp:useBean id="butsPendantP" class="com.soccer.valueobjects.VOBut"
								scope="page" />
							<li> <c:out value="<%=Controleur.getIntervalleDate(debut,butsPendantP.getHeure())%>" /> ' 
								 <img id="imBallon" width="25" height="25" src="images/ballon.png" />
								${butsPendantP.auteur.prenom} ${butsPendantP.auteur.nom} marque pour ${butsPendantP.auteur.nomEquipe}.
							</li>
						</c:forEach>						
						</c:if>
						
						<!-- si le match arrive aux TAB -->
						<c:if test="<%=fin != null && tab%>">
							<li>120 ' <img id="imSifflet" width="25" height="25"
								src="images/sifflet.png" /> Les deux équipes étant encore à
								égalité à l'issu de la prolongation, le match se terminera par des tirs aux buts.
							</li>
							
						<!-- on affiche les TAB marqués -->
						<c:forEach
							items="<%=Controleur.getTAB(debut, Controleur.trierButs(rencontre.getButsHotes(),
								rencontre.getButsVisiteurs()))%>"
							var="butsTAB">
							<jsp:useBean id="butsTAB" class="com.soccer.valueobjects.VOBut"
								scope="page" />
							<li> <img id="imBallon" width="25" height="25" src="images/ballon.png" />
								${butsTAB.auteur.prenom} ${butsTAB.auteur.nom} marque son pénalty pour ${butsTAB.auteur.nomEquipe}.
							</li>
						</c:forEach>
						</c:if>
						
						<!-- affichage vainqueur -->
						<c:if test="<%=fin != null%>">						
						<li> <%=rencontre.getButsHotes().size() > rencontre.getButsVisiteurs().size() ? 
									"<b>L'équipe de " + nomHotes + " remporte la rencontre.</b>" :
									"<b>L'équipe de " + nomVisiteurs + " remporte la rencontre.</b>"%>
						</li>
						</c:if>
					</ol>
				</c:if>
			</div>
	<!-- Fin buts -->
			<div class="clear"></div>
		</div>
<!-- Fin bloc vs -->
	</div>
<!-- Fin body -->

	<jsp:include page="../includes/footer.jsp" />
</body>
</html>