<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Witaj</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<form action="http://localhost:8080/login">
					<button type="submit" class="btn btn-default" >LOGIN</button>
						</form>
					</br>
					<form action="http://localhost:8080/register">
					<button type="submit" class="btn btn-success">REGISTER</button>
						</form>
				</div>
			</div>
		</section>
	</body>
</html>
