<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="evaluationSystemPG1.entities.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%	
	List<Evaluation> evalList = (List<Evaluation>) request.getAttribute("EvalList");
	// TODO Change this temporary code. 
	evalList = new ArrayList<Evaluation>();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alla utvärderingar :: KYH</title>
<link rel="stylesheet" type="text/css" href="main.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="main.js" ></script>
</head>
<body>
	<h1>Utvärdering KYH <a href="/Login">Logga ut</a></h1>
	<nav>
		<ul>
			<li><a href="Evaluations">Utvärdering</a></li>
			<li><a href="Groups">Grupper</a></li>
		</ul>
	</nav>
	
	<h2>Lista på utvärderingar</h2>
	<form>
		<label for="search">Sök</label>
		<input type="text" id="search" name="search" placeholder="Skriv sökord här" />
	</form>
	<table>
		<thead>
			<tr>
				<th>
					<span>Titel</span>
					<!-- 
					Insert with Javascript here.
					 -->
					<span><img src="img/arrow_up.jpg" alt="Pil upp"/></span>
					<span><img src="img/arrow_down.jpg" alt="Pil ner"/></span>
				</th>
				<th><span>Grupp</span></th>
				<th><span>Publicerad</span></th>
				<th><span>Avslutad</span></th>
				<th><span>Ta bort</span></th>
			</tr>
		</thead>
		<tbody>
		<% for(Evaluation e:evalList) { %>
			<tr>
				<td><%= e.getTitle() %></td>
				<td><%= e.getGroup().getGroupName() %></td>
				<td><% //TODO e.getPublishDate() %></td>
				<td><% //TODO e.getFinishDate() %></td>
				<td><img src="img/delete.jpg" alt="Ta bort utv." /></td>
			</tr>
		<tbody>
		<% } %>
	</table>
</body>
</html>