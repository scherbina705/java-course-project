<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stwitter</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/home.css">
    <link rel="stylesheet" href="/resources/css/registration.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <%----%>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

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
                        <li>
                            <a href="/home">Home
                                <span class="glyphicon glyphicon-home"></span>
                            </a>
                        </li>
                        <li><a href="#">My profile</a></li>
                        <li><a href="#">My stwits</a></li>
                        <li><a href="#">Search people <span class="glyphicon glyphicon-search"></span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/registration"><span class="glyphicon glyphicon-user"></span>
                            Register</a></li>
                        <li class="active"><a href="/user-login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">

        </div>

        <c:url value="http://localhost:8080/login" var="loginUrl" />
        <div id="main-content" class="col-md-6">
            <form id="login-form" role="form" action="${loginUrl}" method="post">
                <h3> Please, enter you login and password:.</h3>
                <div class="form-group">
                    <label for="login">*First Name:</label>
                    <input type="text" class="required form-control" name="j_username" id="login"/>
                </div>
                <div class="form-group">
                    <label for="password">*Last Name:</label>
                    <input type="password" class="form-control" name="j_password" id="password"/>
                </div>
                <div class="form-group">
                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                </div>
                <p>
                    <c:if test="${error == true}">
                        <b class="error">Invalid login or password.</b>
                    </c:if>
                </p>
                <button type="submit" class="btn btn-default center-block">Submit</button>
            </form>
        </div>


        <div class="col-md-3">

        </div>
    </div>
</div>
<%----%>

<div class="row">

</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%--for validation form--%>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="/resources/js/registration.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

</body>
</html>