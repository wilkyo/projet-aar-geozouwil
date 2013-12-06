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
	<div id="header">?</div>
	<jsp:include page="../includes/menu.jsp" />
	<div id="body">
		<div id="all_questions">
			<ol id="questions_list">
				<li><a href="#aim">À quoi sert ce site ?</a></li>
				<li><a href="#connection">Comment se connecter à
						l'interface admin ?</a></li>
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
					<li><a href="#addgoal">Comment ajouter un but ?</a></li>
					<li><a href="#errorgoal">Pourquoi ne puis-je pas ajouter
							un but ?</a></li>
					<li><a href="#unvalidable">Pourquoi ne puis-je pas valider
							la rencontre ?</a></li>
					<li><a href="#reload">J'ai ajouté une équipe et elle ne me
							plaît plus</a></li>
				</c:if>
			</ol>
		</div>

		<div id="faq_answers">
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
				<div class="faq_question">Peut-on voir les joueurs d'une
					équipe ?</div>
				Oui. Pour cela, il faut aller sur la page des équipes en cliquant
				sur le menu en forme de deux personnages, puis de sélectionner une
				des équipes.<br /> On peut aussi accéder à une équipe depuis une
				rencontre en cliquant sur son nom.
			</div>
			<div class="faq_item" id="tournament">
				<div class="faq_question">Comment accéder à un tournoi ?</div>
				Depuis l'accueil du site, on peut accéder à un tournoi en cliquant
				simplement sur son nom.
			</div>
			<div class="faq_item" id="match">
				<div class="faq_question">Comment voir les détails d'une
					rencontre ?</div>
				Pour voir les détails d'une rencontre, il suffit de cliquer dessus
				dans le diagramme du tournoi correspondant.
			</div>
			<div class="faq_item" id="endedmatch">
				<div class="faq_question">À quoi reconnaît-on qu'une rencontre
					est terminée ?</div>
				Une rencontre terminée est colorée en vert.
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
					Pour créer un tournoi, il suffit d'aller sur l'accueil
					administrateur en cliquant sur le menu en forme de maison avec un
					personnage sur fond rouge.<br /> Ensuite, il suffit d'entrer le
					nom du tournoi et de valider.<br /> Ceci aura pour effet de
					générer les rencontres en prenant les équipes aléatoirement.
				</div>
				<div class="faq_item" id="errortournament">
					<div class="faq_question">Je ne vois pas l'option permettant
						de créer un tournoi</div>
					Si l'option permettant de créer un tournoi n'est pas présente,
					c'est probablement car le nombre d'équipes n'est pas une puissance
					de deux.<br /> Il faudra donc ajouter des équipes jusqu'à
					atteindre ce seuil.
				</div>
				<div class="faq_item" id="addreferee">
					<div class="faq_question">Comment ajouter un arbitre ?</div>
					Pour créer un tournoi, il suffit d'aller sur l'accueil
					administrateur en cliquant sur le menu en forme de maison avec un
					personnage sur fond rouge.<br /> Ensuite, vers le bas de la page,
					il faut entrer le nom et le prénom de l'arbitre à ajouter dans les
					champs correspondants et valider.
				</div>
				<div class="faq_item" id="editmatch">
					<div class="faq_question">Comment éditer une rencontre ?</div>
					Pour éditer une rencontre, il faut commencer par aller dans le
					tournoi correspondant puis cliquer sur la rencontre que l'on désire
					éditer.<br /> On commence par définir la date et l'heure de début
					de la rencontre et l'arbitre qui s'en occupera.<br /> Une fois
					validé, vous pouvez ajouter des buts puis valider la rencontre.
				</div>
				<div class="faq_item" id="addgoal">
					<div class="faq_question">Comment ajouter un but ?</div>
					Pour ajouter un but, il faut se rendre sur la page d'édition d'une
					rencontre dont la date de début et l'arbitre ont été définis,
					choisir l'équipe qui a marqué. Ceci aura pour effet de faire
					apparaître la liste des joueurs de cette équipe.<br /> Il faut
					ensuite sélectionner le joueur qui a marqué puis entrer la minute
					(entre la 0ème et 135ème) à laquelle le but a été enregistré.
				</div>
				<div class="faq_item" id="errorgoal">
					<div class="faq_question">Pourquoi ne puis-je pas ajouter un
						but ?</div>
					Pour pouvoir ajouter un but, il faut que la rencontre soit passée.
					En effet, on ne peut pas prévoir les buts qu'il y aura dans
					l'avenir.<br /> De la même manière, on ne peut pas ajouter un but
					avant un autre. Il faut donc les entrer dans leur ordre d'arrivée.<br />
					Pour finir, deux buts ne peuvent pas avoir été marqué à la même
					minute, soyons réalistes, sauf pendant les tirs aux buts.
				</div>
				<div class="faq_item" id="unvalidable">
					<div class="faq_question">Pourquoi ne puis-je pas valider la
						rencontre ?</div>
					Pour pouvoir valider la rencontre, il suffit qu'il n'y ait pas
					d'égalité.
				</div>
				<div class="faq_item" id="reload">
					<div class="faq_question">J'ai ajouté une équipe et elle ne
						me plaît plus</div>
					Vous pouvez recharger la Base de données comme elle était au
					lancement du serveur. Les fichiers XML de base seront rechargés et
					tout repartira du début.
				</div>
			</c:if>
		</div>
	</div>

	<jsp:include page="../includes/footer.jsp" />
</body>
</html>