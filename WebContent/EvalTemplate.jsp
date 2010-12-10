<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="evaluationSystemPG1.entities.Evaluation"%>
<%@page import="evaluationSystemPG1.entities.Group"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<% 	Evaluation et = (Evaluation) request.getAttribute("evalTemplate");
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
		<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
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
		<form action="" method="get">
			<div id="status">
				<input type="submit" name="publish" value="Publicera" />
				<input type="submit" name="finish" value="Avsluta" />
			</div>
			
			<div id="title_div">
				<label for="title">Titel</label>
				<input type="text" id="title" class="title" name="eval_.title" />
			</div>
			
			<div id="group_div">
				<label for="group">Grupp</label>
				<select id="group" name="eval_.group">
					<% for(Group g : gs) { %> 
					<option value="<%= g.getId() %>"><%= g.getGroupName() %></option>
					<% } %>
				</select>
			</div>
			
			<div id="create">
				<input type="button" name="create_section" value="Skapa sektion" />
				<input type="button" name="create_question" value="Skapa ny fråga" />
			</div>
			
			<div id="save">
				<input type="submit" name="save_eval" value="Spara utvärdering" />
			</div>
		</form>
	</body>
</html>