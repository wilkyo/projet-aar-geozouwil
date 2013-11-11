<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	String action = request.getParameter("action");
	if (action == null)
		action = Controleur.ACTION_HOME;
%>
<div id="menu">
	<ul>
		<li><a href="?action=home"><img id="imLog" alt="Accueil"
				title="Accueil" src="images/home.png"
				<%=action.equals(Controleur.ACTION_HOME) ? " class=\"active\""
					: ""%>></a></li>
		<li><a href="?action=login"><img id="imLog"
				alt="Se connecter" title="Se connecter" src="images/login.png"
				<%=action.equals(Controleur.ACTION_LOGIN) ? " class=\"active\""
					: ""%>></a></li>
		<li><a href="?action=newteam"><img id="imPass"
				alt="Nouvelle equipe" title="Nouvelle equipe" src="images/team.png"
				<%=action.equals(Controleur.ACTION_NEW_TEAM) ? " class=\"active\""
					: ""%>></a></li>
	</ul>
	<div class="clear"></div>
</div>