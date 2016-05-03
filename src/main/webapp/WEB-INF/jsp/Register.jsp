<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Better Than Trello Registr page</h1>

        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-5 col-md-offset-5">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Utworz konto </h3>
                </div>
                <div class="panel-body">


                    <form:form method="post" action="register/add" commandName="user">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nazwa użytkownika" name='name' type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Hasło" name='password'  type="password" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="potwierdz Hasło" name='confirm_password'  type="password" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="email" name='email'  type="text" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Zarejestrujj">
                        </fieldset>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger">
                                <p> ${error} </p>
                            </div>
                        </c:if>
                    </form:form>
                    <p> ${error} </p>

                </div>
            </div>
        </div>
    </div>
</div>
</body>

