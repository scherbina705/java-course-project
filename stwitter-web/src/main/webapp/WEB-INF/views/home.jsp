<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stwitter</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/home.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                        <li><a href="/not-ready">My profile</a></li>
                        <li><a href="/not-ready">My stwits</a></li>
                        <li><a href="/not-ready">Search people <span class="glyphicon glyphicon-search"></span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                        <li><a href="/not-ready"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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

            <c:if test="${fn:length(latestPosts) == 0}">
                <h3>Uuups, there are no posts yet...</h3>
            </c:if>
            <c:forEach var="postDto" items="${latestPosts}">
                <div class="stwitt">
                    <div class="row stwitt-block">
                        <div class="avatar col-md-1 pull-left">
                            <img src="/resources/images/avatars/${personAvatarsMap.get(postDto.authorLogin)}.jpg"
                                 class="img-thumbnail avatar"/>
                        </div>
                        <div class="stwitt-content col-md-11 pull-right">
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
            <c:choose>
                <c:when test="${fn:length(allPersons) == 0}">
                </c:when>
                <c:otherwise>
                    <form id="send-post-form" role="form" action="/addNewPost" method="post">
                        <h4 class='text-center'> <u>Send new post for user:</u></h4>
                        <p><span class='glyphicons glyphicons-tick'></span></p>
                        <div class="form-group">
                            <label for="person">Select person:</label>
                            <select class="form-control" id="person">
                                <c:forEach var="personDto" items="${allPersons}">
                                    <option>${personDto.login}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="title">*Title:</label>
                            <input type="text" class="required form-control" name="title" id="title"/>
                        </div>
                        <div class="form-group">
                            <label for="content">*Content:</label>
                            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
                        </div>
                        <button type="submit" class="btn btn-default center-block">Submit</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%----%>

<div class="row">

</div>
</div>

<script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/home.js"></script>
</body>
</html>