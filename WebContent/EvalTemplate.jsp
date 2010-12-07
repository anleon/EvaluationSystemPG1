<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="evaluationSystemPG1.entities.EvalTemplate"%>
<%@page import="evaluationSystemPG1.entities.Group"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<% 	EvalTemplate et = (EvalTemplate) request.getAttribute("evalTemplate");
	 List<Group> gs = (List<Group>) request.getAttribute("groups");
	// Temporary test code
		gs = new LinkedList<Group>();
		Group gg = new Group();
		gg.setGroupName("AD10");
		gs.add(gg);

	// End temporary test code
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Ny Utvärdering</title>
		<link rel="stylesheet" type="text/css" href="main.css" />
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
		<script type="text/javascript" src="main.js"></script>
	</head>
	<body>
		<h1>Utvärdering KYH <a href="/login">Logga ut</a></h1>
		<hr />
		<nav>
			<ul>
				<li><a href="">Utvärdering</a></li>
				<li><a href="">Grupper</a></li>
			</ul>
		</nav>
		<hr />
		<form action="" method="post">
			<input type="text" name="title" />
			
			<select>
				<% for(Group g : gs) { %> 
				<option name="<%= g.getId() %>"><%= g.getGroupName() %></option>
				<% } %>
			</select>
			
			<input type="submit" name="" value="Skapa" />
			<input type="submit" name="" value="Ändra" />
			<input type="submit" name="" value="Ta bort" />
		</form>
	</body>
</html>