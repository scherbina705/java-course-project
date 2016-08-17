<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stwitter</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/home.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav id="menu" class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <img id="logo" src="/resources/images/logo.png" width="70 px" data-toggle="tooltip"
                             title="Stwitter"/>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="/home">Home
                                <span class="glyphicon glyphicon-home"></span>
                            </a>
                        </li>
                        <li><a href="#">My profile</a></li>
                        <li><a href="#">My stwits</a></li>
                        <li><a href="#">Search people <span class="glyphicon glyphicon-search"></span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Register</a></li>
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

            <c:forEach var="postDto" items="${latestPosts}">
                <div class="stwitt">
                    <div class="row stwitt-block">
                        <div class="avatar col-md-1">
                            <img src="/resources/images/avatars/${postDto.authorLogin}/avatar.jpg"
                                 class="img-thumbnail avatar"/>
                        </div>
                        <div class="stwitt-content col-md11">
                            <div class="author">
                                <p><b>
                                    <a href="/temp.html">${postDto.authorLogin}</a> &rarr; ${postDto.title}
                                </b>
                                </p>
                            </div>
                            <div class="stwitt-text">
                                <p>${postDto.content}</p>
                            </div>
                            <div class="stwitt-meta-info text-right">
                                <p><em>&rarr; Posted on <joda:format value="${postDto.placeTime}" pattern="YYYY/M/d"/>
                                    at <joda:format value="${postDto.placeTime}" pattern="hh:mm:ss"/></em>
                                </p>
                                <p><span class="glyphicon glyphicon-heart text-left"></span> ${postDto.postLikes}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
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
</body>
</html>