<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wp
  Date: 24.05.2016
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Task</title>

    <style>
        html {
            text-align: center;
            width:40%;
            border:2px solid #000;
            padding:20px 50px;
            margin:0 auto;
            box-sizing:border-box;
        }

    </style>
</head>
<body >

<h3><span class="label label-default">${task.title}</span></h3>

</br>


<div class="form-group">
    <label for="description">Description:</label>
    <textarea class="form-control" rows="3" id="description">${task.description} </textarea>
</div>
<a href="" class="btn btn-success">UpdatetTask</a>
</br>
<div class="form-group">
    <label for="comment">Comment:</label>
    <textarea class="form-control" rows="5" id="comment"></textarea>
</div>
<div class="form-grup">
    <label>Set Label Task:</label>


    <form:form method="post" action="label/add" commandName="newLabel">
        <fieldset>
            <div class="form-group">

                <input type="color" name="color" value="#ff0000">
                <center>
                <input class="btn btn-lg btn-success btn-block" type="submit" value="Add new label" style="width:25%">
                </center>
            </div>


        </fieldset>
    </form:form>

</div>
<div >

<center>
            <table>
                <c:forEach items= "${labelList}" var="label">
                <tr>
                    <td style="background: ${label.color}; width:80px" >${label.id}</td>
                            <td><a href="/Dashboard/column/label/addLabelTask?idLabel=${label.id}" class="btn btn-success">UpdatetTask</a></td>
                </tr>
                    </c:forEach>
            </table>
</center>

           <%-- <c:forEach items= "${labelList}" var="label">
                <div>
                <div style="background: ${label.color} ;height: 20px" value="${label.color}">${label.id}</div>
                <a href="/Dashboard/column/label/addLabelTask?idLabel=${label.id}" class="btn btn-success">UpdatetTask</a>
                </div>
            </c:forEach>--%>




    </div>
<%--<a href="" class="btn btn-success">AddComment</a>


<div>--%>
<%--<tr><td><a href="" class="btn btn-primary btn-block">MEMBERS</a></td></tr>
</br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">ChecKList</a></td></tr>
    </br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">DueD ate</a></td></tr>
    </br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">Attachment</a></td></tr>

</div>--%>

</body>
</html>
