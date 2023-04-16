<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de bibliothèque</title>
<link rel="stylesheet" href="../css/styles.css">
</head>

<body>
	<h1>${title }</h1>
	<%
		List<Author> authors = (List<Author>) request.getAttribute("authors");
	%>
	<table class="data-table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom de l'auteur</th>
				<th>Année</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Author a : authors) {
			%>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getName()%></td>
				<td><%=a.getYearBorn()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>