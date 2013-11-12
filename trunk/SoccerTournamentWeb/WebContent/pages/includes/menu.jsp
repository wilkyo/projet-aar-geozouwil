<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	String action = request.getParameter("action");
	if (action == null)
		action = Controleur.ACTION_HOME;
	boolean logged = request.getSession().getAttribute("admin") != null;
%>
<div id="menu">
	<ul>
		<li><a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_HOME%>"><img
				id="imLog" alt="Accueil" title="Accueil" src="images/home.png"
				<%=action.equals(Controleur.ACTION_HOME) ? " class=\"active\""
					: ""%>></a></li>
		<li><a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_TEAM%>"><img
				id="imPass" alt="Équipes" title="Équipes" src="images/equipes.png"
				<%=action.equals(Controleur.ACTION_TEAM) ? " class=\"active\""
					: ""%>></a></li>
		<c:if test="<%=logged%>">
			<li><a
				href="<%=Controleur.SERVLET_PATH
						+ Controleur.ACTION_ADMIN_HOME%>"><img
					id="imLog" alt="Accueil Admin" title="Accueil Admin"
					src="images/homeAdmin.png"
					<%=action.equals(Controleur.ACTION_ADMIN_HOME) ? " class=\"active\""
						: ""%>></a></li>
			<li>
		</c:if>
		<c:if test="<%=!logged%>">
			<li><a
				href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_NEW_TEAM%>"><img
					id="imPass" alt="Nouvelle equipe" title="Nouvelle equipe"
					src="images/team.png"
					<%=action.equals(Controleur.ACTION_NEW_TEAM) ? " class=\"active\""
						: ""%>></a></li>
		</c:if>
		<li><a
			href="<%=Controleur.SERVLET_PATH + Controleur.ACTION_LOGIN%>"><img
				id="imLog" alt="Se connecter"
				title="<%=logged ? "Se déconnecter" : "Se connecter"%>"
				src="images/<%=logged ? "deconnecte.png" : "login.png"%>"
				<%=action.equals(Controleur.ACTION_LOGIN) ? " class=\"active\""
					: ""%>></a></li>
	</ul>
	<div class="clear"></div>
</div>