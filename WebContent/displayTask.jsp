<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css" title="currentStyle">
	@import "css/jquery.dataTables.css";

	

</style>

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
    	oTable = $('#newTaskTable').dataTable();
    
} );
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" /> -->
<title>Prva vježba</title>
</head>
<body>

	<center>

		<div>
			<h1 id="displayTitle">Prikaz novog zadatka</h1>
		
			<h2>Podaci o legendarnim zadacima</h2>

			
			<table id="newTaskTable" border="1">
			
			
			
			<thead>

				<tr>
				
					<th>Ime</th>
					<th>Prezime</th>
					<th>Korisničko ime</th>
					<th>Album</th>
					<th>Izdavač</th>
					<th>Opis projekta</th>
					<th>Procjena trajanja (h)</th>
					
				</tr>
				
			</thead>
			
			<tbody>
			
			<c:forEach items="${sessionScope.taskList}" var="taskVar">
				
				<tr>
				
	
					<td><c:out value='${taskVar.user.userFirstName}'/></td>
					
					<td><c:out value="${taskVar.user.userLastName}" /></td>
					
					<td><c:out value="${taskVar.user.userName}" /></td>
					
					<td><c:out value="${taskVar.project.projectName}" /></td>
					
					<td><c:out value="${taskVar.project.projectCompany}" /></td>
					
					<td><c:out value="${taskVar.taskDescription}" /></td>
					
					<td><c:out value="${taskVar.estimatedTime}" /></td>
					
					
					
				</tr>
				
			</c:forEach>
				
				</tbody>
				
			
				
			</table>
			
			</div>
			
			<form action="<c:url value="/showTask"/>" method="GET">
			
				<input type="submit" name="saveButton" value="Povratak">
			
			</form>
			
		

	</center>

</body>
</html>