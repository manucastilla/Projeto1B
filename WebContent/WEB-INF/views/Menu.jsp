<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, mvc.controller.*, mvc.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags"%>

	

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
<jsp:useBean id="dao" class="mvc.model.NotesDAO"/>
<a href ="logout">sair</a><br>
	<%!String user;%>

	<%
		user = (String) session.getAttribute("user");
	%>

	
		<h1>BEM VIND@ <%=user%> !</h1><br>
		
		<form action="postar" method="post">
			<input type="hidden" name="user" value="<%=user%>" readonly>
			<label>Assunto:</label> <br />
			<input type="text"
				name="titulo" size="40" maxlength="100"><br /> 
				<label
				for="user">Notas:</label><br />
			<textarea rows="10" cols="40" name="nota"> </textarea>
			<div class="button">
				<button type="submit">Postar</button>
			</div>
		</form>
	
	<div class="card" style="width: 18rem;">

	<%
		UserDAO daoUser = new UserDAO();
		NotesDAO daoNotes = new NotesDAO();
	

		List<Notes> lista = daoNotes.getLista(user);

		for (Notes nota : lista) {
	%>
	
	<div class="card border-primary bg-primary mb-3" style="max-width: 18rem;">
	<form action="editaGet" method="get">
	    <h5 class="card-title"><%=nota.getTitulo()%></h5>
	    <p class="card-text"><%=nota.getNota()%></p>
	    <input name="user" type="hidden" value= "${user}">
	    <input name="titulo" value="<%=nota.getTitulo()%>" type="hidden">
	    <input name="nota" value="<%=nota.getNota()%>" type="hidden">
	    <input name="id" value="<%=nota.getId()%>" type="hidden">
	   	<input type="submit" value="editar">
	</form>
	<form action="delete" method="post">
	     <input name="id" value="<%=nota.getId()%>" type="hidden">
	     <input name="nome" type="hidden" value= "${user}">
	 
	 <input type="submit" value="apagar">
	 </form>
  	</div>
  <%
		}
	%>
	
</div>



</body>
</html>