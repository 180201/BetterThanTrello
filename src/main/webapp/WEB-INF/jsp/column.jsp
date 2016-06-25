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
    <link rel="stylesheet"  href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
    <title>Board</title>
</head>
<body>
<style>
    .container li { margin: 5px; padding: 5px; border-style: ridge; }
     .dragAndDropTask { min-height: 40px;}
    .container ul {list-style:none;}
    .liColumn{float:left;}

</style>
<script type="text/javascript">

    $( init );

    function init() {
        $("#sortableColumn").sortable({
            revert: true,
            stop: function(event, ui) {
                let columns = [];
                $('.liColumn').each(function(){
                    columns.push(this.id);
                });
                console.log(columns);
                $.ajax({
                    type : "Get",
                    url : "/Dashboard/column/orderColumns",
                    data:"&orderColumns="+columns
                });
                //TUTAJ WYWOLASZ METODE Z KONTROLERA sortujaca kolumny
                // columns < TO DASZ JAKO PARAMETR < TO JEST KOLEJOSC KOLUMN
            }
        });

        $("ul.dragAndDropTask").sortable({ // nie dziala przenoszenie miedzy kolumanmi bo nie wiem jak to zrobic w tym forze i nie chce mi sie kombinowac
            revert: true,
            connectWith : "ul.dragAndDropTask",
            activate: function( event, ui ) {

            },
            stop: function(event, ui) {
                let tasks = [];
                let parent;
                $('.liTask').each(function(){
                    tasks.push($(this).parent().parent().attr('id')+':'+this.id);
                });
                console.log(tasks);
                $.ajax({
                    type : "Get",
                    url : "/Dashboard/column/orderTasks",
                    data:"&orderTasks="+tasks
                });
                //TUTAJ WYWOLASZ METODE Z KONTROLERA sortujaca taski
                // tasks < TO DASZ JAKO PARAMETR < TO JEST KOLEJOSC tasków, a biorac pod uwage ze parent nam sie nie zmienia to jebac go masz to info w bazie
            }
        });
    }

</script>
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
            <div id="sortableColumn">
                <c:forEach items="${mapt}" var="mapkey">
                    <li id="${mapkey.key.id}" class="liColumn thumbnail">
                        <a href="/Dashboard/column/editcolumn?idColumn=${mapkey.key.id}" >Edit</a>
                        <a href="/Dashboard/column/deletecolumn?idColumn=${mapkey.key.id}" >Delete</a>
                            ${mapkey.key.title}


                            <ul id="sortableTask" class="dragAndDropTask">
                                <c:if test="${mapkey.value.size()>0}">
                                <c:forEach items= "${mapkey.value}" var="mapval">
                                    <li id="${mapval.id}" class="liTask noChange">
                                        <a href="/Dashboard/column/Task?idTask=${mapval.id}"> ${mapval.title} </a>
                                        <a href="/Dashboard/column/Task/delete?idTask=${mapval.id}" class="btn btn-default btn-sm"> delete </a>
                                        <br/>
                                        <br/>
                                        <div style="height: 10px; width:25%; background-color:${mapval.labelInTask.color}">

                                        </div>
                                    </li>
                                </c:forEach>
                                </c:if>
                            </ul>



                        <a href="http://localhost:8080/Dashboard/column/Task/add?column=${mapkey.key.id}" class="btn btn-success">AddTask</a>
                    </li>

                </c:forEach>


            </div>



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
<section>

</section>


</body>
</html>