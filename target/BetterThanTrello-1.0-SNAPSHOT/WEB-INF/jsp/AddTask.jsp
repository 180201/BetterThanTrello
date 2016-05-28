<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Add task</h1>

        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <%--<div class="panel-heading">--%>
                    <%--<h3 class="panel-title">Zaloguj się</h3>--%>
                <%--</div>--%>
                <div class="panel-body">


                    <form:form method="post" action="add" commandName="Task">
                        <fieldset>
                            <div class="form-group">
                                <input width="500px" height="300px" class="form-control" placeholder="title" name='title' type="text" >
                            </div>
                            <div class="form-group">
                                <input  class="form-control" placeholder="description" name='description'  type="text" value="">
                                <input class="form-control" placeholder="trolloColumn" name='trolloColumn'  type="hidden" value=${columnId}>
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Add">


                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

