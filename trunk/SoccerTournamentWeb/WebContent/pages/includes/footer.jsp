<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<%
	String action = request.getParameter("action");
	if (action == null)
		action = Controleur.ACTION_HOME;
	boolean logged = request.getSession().getAttribute("admin") != null;
%>
<div id="footer">
	<a class="right"
		href="<%=Controleur.SERVLET_PATH%><%=Controleur.ACTION_SWITCH_CSS%>">CSS
		(<%=Controleur.getCSS()%>)
	</a>
	<c:if test="<%=logged%>">
		<form class="left" method="post"
			action="<%=Controleur.SERVLET_PATH + Controleur.ACTION_RELOAD_DB%>">
			<input type="submit" value="Recharger la BDD" />
		</form>
	</c:if>
	&copy; 2013<br />Geoffrey CROCHET - Zo RABARIJAONA - Willy FRANÇOIS
</div>