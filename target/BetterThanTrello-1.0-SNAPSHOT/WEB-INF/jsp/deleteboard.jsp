<%--
  Created by IntelliJ IDEA.
  User: Winiu
  Date: 06-05-2016
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Delete Board</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Better Than Trollo Edit Board Page</h1>

        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Czy na pewno chceesz usnac ${title}? </h3>
                </div>
                <div class="panel-body">


                    <form:form method="delete" action="/Dashboard/deleteboard" commandName="deleteBoard">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" name='title' value="${title}" type="text" disabled="disabled">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name='id' value="${idBoard}" type="hidden">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Usun">
                            <a class="btn btn-lg btn-success btn-block" href="/Dashboard">Anuluj</a>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>



