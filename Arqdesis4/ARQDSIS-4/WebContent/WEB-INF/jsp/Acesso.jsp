<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="./resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="./resources/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acesso</title>
</head>
<body>

	<c:if test="${error}">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p class="text-danger msg-error">Dados inválidos, por favor tente novamente.</p>
			</div>
		</div>
	</c:if>

	<div class="container">
		<div class="row">
			<div class="div-principal col-md-3 col-md-offset-4">
				<h1>Acesso</h1>
				<form action="Acesso.do" method="POST">
					<div class="form-group">
						<label for="agencia">Agência:</label> <input class="form-control"
							name="agencia" id="agencia" placeholder="Digite sua agência">
					</div>
					<div class="form-group">
						<label for="conta">Conta:</label> <input class="form-control"
							name="conta" id="conta" placeholder="Digite sua conta">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="senha" id="pwd"
							placeholder="Digite sua senha">
					</div>
					<input  type="submit" name="OK" value="OK" >
				</form>
			</div>
		</div>
	</div>
</body>
</html>