<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/custom.tld" prefix="custom"%>
<%@ page import="com.soccer.servlet.Controleur"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>base.css" />
<link type="text/css" rel="stylesheet"
	href="<%=Controleur.WEB_PATH%><%=Controleur.CSS_PATH%>menu.css" />
<title>Home</title>
</head>
<body>
	<div id="header"><%=request.getParameter("id")%></div>
	<jsp:include page="includes/menu.jsp" />
	<div id="body">
		<c:forEach items="${rencontres}" var="rencontre">
			<jsp:useBean id="rencontre"
				class="com.soccer.valueobjects.VORencontreLight" scope="page" />
			<%=rencontre.getId()%>
			<br />
			<c:out value="${rencontre.id}" />
		</c:forEach>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>