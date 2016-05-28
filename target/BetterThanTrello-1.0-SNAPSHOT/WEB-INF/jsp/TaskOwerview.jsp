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

<h3><span class="label label-default">TITLE </span>${task.title}</h3>

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
<a href="" class="btn btn-success">AddComment</a>


<div>
<tr><td><a href="" class="btn btn-primary btn-block">MEMBERS</a></td></tr>
</br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">ChecKList</a></td></tr>
    </br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">DueD ate</a></td></tr>
    </br>
    </br>
    <tr><td><a href="" class="btn btn-primary btn-block">Attachment</a></td></tr>

</div>

</body>
</html>
