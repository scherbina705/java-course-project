<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stwitter</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/main.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean id="test" scope="request" type="com.stwitter.controller.Test"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav id="menu" class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <img src="/resources/images/logo.png" width="80 px" data-toggle="tooltip" title="Stwitter">
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Home
                                <span class="glyphicon glyphicon-home"></span>
                            </a>
                        </li>
                        <li><a href="#">My profile</a></li>
                        <li><a href="#">My stwits</a></li>
                        <li><a href="#">Search people <span class="glyphicon glyphicon-search"></span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <%--Latests stweets--%>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div id="main-content" class="col-md-6">
            <h2>What people stwitted recently:</h2>
            <%--Message block--%>
            <div class="stwitt-block">
                <div class="avatar">
                    <img src="/resources/images/avatar-temp.jpg" class="img-thumbnail" width="75" height="75">
                </div>
                <div class="stwitt-content">
                    <div class="author">
                        <a href="/temp.html">Temp tempov</a>
                    </div>
                    <div class="stwitt-text">
                        <p>Один из наших сотрудников поехал в отпуск и взял с собой пузырёк с красной краской. И знаете
                            зачем? Чтобы в случае терроризма - стрельбы в общественных местах, притворится мёртвым,
                            вылив её на себя. Шёл 2016 год... ${test.abc}</p>
                    </div>
                    <div class="stwitt-meta-info">
                        <p><em>&rarr; Posted on 12.07.2016 at 16:45</em></p>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-3">

        </div>
    </div>
</div>
<%----%>

<div class="row">

</div>
</div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/my-script.js"></script>
</body>
</html>
