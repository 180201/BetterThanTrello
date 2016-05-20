<%--
  Created by IntelliJ IDEA.
  User: Winiu
  Date: 20-05-2016
  Time: 20:32
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
    <title>Board</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Better Than Trollo Column Page</h1>

        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">

            <c:forEach items="${columnList}" var="column">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">
                        <a href="/Dashboard/column/editcolumn?idColumn=${column.id}" >Edit</a>
                        <a href="/Dashboard/column/deletecolumn?idColumn=${column.id}" >Delete</a>
                        <div class="caption">
                            <h3>${column.title}</h3>

                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

        <div class="panel panel-default">

            <div class="col-md-4 col-md-offset-4">
                <div class="panel-heading">
                    <h3 class="panel-title">Utworz nowa kolumne</h3>
                </div>
                <div class="panel-body">


                    <form:form method="post" action="column/add" commandName="newColumn">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nazwa kolumny" name='title' type="text">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Utworz">
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
<%--<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <div class="panel panel-default">


                <div class="panel-heading">
                    <h3 class="panel-title">Utworz nowa tablice</h3>
                </div>
                <div class="panel-body">


                    <form:form method="post" action="Dashboard/add" commandName="newBoard">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nazwa tablicy" name='title' type="text">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Utworz">
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>--%>
</div>
</body>
</html>
