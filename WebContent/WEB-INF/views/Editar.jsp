<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
	<%!String user;
		String nota;
		String titulo;
		int id;%>

	<%
		user = (String) session.getAttribute("user");
		nota = (String) session.getAttribute("nota");
		titulo = (String) session.getAttribute("titulo");
		id = (int) session.getAttribute("id");
	%>
	
	<%=user%><br>
		<form action="editar" method="get">
			<input type="hidden" name="nome" value="<%=user%>" readonly>
			<input type="hidden" name="id" value="<%=id%>" readonly>
			<label for="nome">Assunto:</label> <br />
			<input type="text"
				name="titulo" size="40" maxlength="100" value="<%=titulo%>"><br /> 
				<label>Notas:</label><br />
			<textarea  rows="10" cols="40" name="nota"><%=nota%></textarea>
			<div class="button">
				<button type="submit">Atualizar</button>
			</div>
		</form>
	
</body>
</html>