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
		<title>Utvärdering :: KYH</title>
		<link rel="stylesheet" type="text/css" href="main.css" />
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
		<script type="text/javascript" src="jquery-1.4.2.min.js" ></script>
		<script type="text/javascript" src="addAlternative.js" ></script>
	</head>
	<body>
		<h1>Utvärdering KYH <a href="/Login">Logga ut</a></h1>
		<nav>
			<ul>
				<li><a href="Evaluations">Utvärdering</a></li>
				<li><a href="Groups">Grupper</a></li>
			</ul>
		</nav>
		<form action="" method="post">
			<input type="submit" name="publish" value="Publicera" />
			<input type="submit" name="finish" value="Avsluta" />
			
			<label for="title">Titel</label>
			<input type="text" id="title" name="title" />
			
			<label for="group">Grupp</label>
			<select id="group" name="group">
				<% for(Group g : gs) { %> 
				<option value="<%= g.getId() %>"><%= g.getGroupName() %></option>
				<% } %>
			</select>
			
			<input type="submit" name="create_section" value="Skapa sektion" />
			<input type="submit" name="create_question" value="Skapa ny fråga" />
			
			<input type="submit" name="save_eval" value="Spara utvärdering" />
		</form>
	</body>
</html>