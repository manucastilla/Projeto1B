<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PaginaInicial</title>
</head>
<body>

<div class ="container center">
	<h1>Entra na sua conta: </h1>
<form action="fazLogin" method="post">
    <div>
        <label for="nome">Username:</label>
        
        <input type="text" id="nome" name="login" />
    </div>
    <div>
        <label for="password">senha:</label>
        <input type="password"  required='required'id="password" name="password"/>
    </div>
    <div class="button">
        <button type="submit">Entrar</button>
    </div>
</form>

<h1>Cadastre-se </h1>
<form action="fazSignUp" method="post">
    <div>
        <label for="nome">Username:</label>
        <input type="text" id="nome" name="login"/>
    </div>
    <div>
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" />
    </div>
        <div>
        
        <label for="checkPassword">Confirme a senha:</label>
        <input type="password" id="checkPassword" name="checkPassword" />
    </div>
    <div class="button">
        <button type="submit">Entrar</button>
    </div>
</form>


	</div>


</body>
</html>