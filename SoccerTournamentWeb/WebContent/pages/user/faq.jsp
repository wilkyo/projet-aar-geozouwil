<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	boolean logged = request.getSession().getAttribute("admin") != null;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_BASE)%>" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_MENU)%>" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.getCSSPath(Controleur.CSS_FAQ)%>" />
<title>FAQ</title>
</head>
<body>
	<div id="header"></div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<ol id="questions_list">
			<li><a href="#aim">À quoi sert ce site ?</a></li>
			<li><a href="#connection">Comment se connecter à l'interface
					admin ?</a></li>
			<li><a href="#team">Peut-on voir les joueurs d'une équipe ?</a></li>
			<li><a href="#tournament">Comment accéder à un tournoi ?</a></li>
			<li><a href="#match">Comment voir les détails d'une
					rencontre ?</a></li>
			<li><a href="#endedmatch">À quoi reconnaît-on qu'une
					rencontre est terminée ?</a></li>
			<li>&nbsp;</li>
			<li><a href="#newteam">Comment créer une équipe ?</a></li>
			<li><a href="#errornewteam">Pourquoi mon équipe ne se crée
					pas ?</a></li>
			<li><a href="#moreplayers">Peut-on avoir plus de 11 joueurs
					?</a></li>
			<c:if test="<%=logged%>">
				<li>&nbsp;</li>
				<li><a href="#createtournament">Comment créer un tournoi ?</a></li>
				<li><a href="#errortournament">Je ne vois pas l'option
						permettant de créer un tournoi</a></li>
				<li><a href="#addreferee">Comment ajouter un arbitre ?</a></li>
				<li><a href="#editmatch">Comment éditer une rencontre ?</a></li>
				<li><a href="#errorgoal">Pourquoi ne puis-je pas ajouter un
						but ?</a></li>
				<li><a href="#unvalidable">Pourquoi ne puis-je pas valider
						la rencontre ?</a></li>
			</c:if>
		</ol>

		<!-- Utilisateur -->
		<div class="faq_item" id="aim">
			<div class="faq_question">À quoi sert ce site ?</div>
			C'est un site de gestion de tournoi de football. On peut y consulter
			les tournois en cours ou terminés et voir les détails des rencontres
			et équipes.
		</div>
		<div class="faq_item" id="connection">
			<div class="faq_question">Comment se connecter à l'interface
				admin ?</div>
			Il faut pour cela aller sur la page de connexion en cliquant sur le
			menu en forme de clef.<br /> Ensuite, il faut entrer le nom
			d'utilisateur et le mot de passe correspondant.
		</div>
		<div class="faq_item" id="team">
			<div class="faq_question">Peut-on voir les joueurs d'une équipe
				?</div>
		</div>
		<div class="faq_item" id="tournament">
			<div class="faq_question">Comment accéder à un tournoi ?</div>
		</div>
		<div class="faq_item" id="match">
			<div class="faq_question">Comment voir les détails d'une
				rencontre ?</div>
		</div>
		<div class="faq_item" id="endedmatch">
			<div class="faq_question">À quoi reconnaît-on qu'une rencontre
				est terminée ?</div>
		</div>

		<!-- Représentant -->
		<div class="faq_item" id="newteam">
			<div class="faq_question">Comment créer une équipe ?</div>
			Il suffit de cliquer sur le menu "Nouvelle équipe" (en forme de
			footballeur) et de remplir les champs demandés.
		</div>
		<div class="faq_item" id="errornewteam">
			<div class="faq_question">Pourquoi mon équipe ne se crée pas ?</div>
			Soit le nom existe déjà, soit vous n'avez pas entré les 11 joueurs
			requis.
		</div>
		<div class="faq_item" id="moreplayers">
			<div class="faq_question">Peut-on avoir plus de 11 joueurs ?</div>
			Oui. Il suffit de cliquer sur le bouton "+" en bas de la page afin
			d'augmenter le nombre de joueurs jusqu'à 15 maximum.
		</div>
		<c:if test="<%=logged%>">

			<!-- Admin -->
			<div class="faq_item" id="createtournament">
				<div class="faq_question">Comment créer un tournoi ?</div>
			</div>
			<div class="faq_item" id="errortournament">
				<div class="faq_question">Je ne vois pas l'option permettant
					de créer un tournoi</div>
			</div>
			<div class="faq_item" id="addreferee">
				<div class="faq_question">Comment ajouter un arbitre ?</div>
			</div>
			<div class="faq_item" id="editmatch">
				<div class="faq_question">Comment éditer une rencontre ?</div>
			</div>
			<div class="faq_item" id="errorgoal">
				<div class="faq_question">Pourquoi ne puis-je pas ajouter un
					but ?</div>
			</div>
			<div class="faq_item" id="unvalidable">
				<div class="faq_question">Pourquoi ne puis-je pas valider la
					rencontre ?</div>
			</div>
		</c:if>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>