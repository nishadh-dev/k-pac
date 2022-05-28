<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <title>K-Pac</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/grid.min.js?v=7.3.3"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/grid.min.css?v=7.3.3"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/app.css?v=1.20"/>"/>
    <script>
        const number = [[${kpacId}]];
    </script>
</head>

<body onload="set_kPacs()">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/app/kpacs">K-Pac</a></li>
                <li class="active"><a href="#">Set</a></li>
            </ul>
        </div>
    </div>
</nav>

<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>K-Pacs</h3>
                <section class="dhx_sample-container" style="min-height: 400px; height: 400px">
                    <div class="grid" id="kpac-set-grid"></div>
                </section>
            </div>
        </div>
    </div>

</main>
<script type="text/javascript" src="<c:url value="/resources/js/app-kpac-set.js?v=1.20"/>"></script>
</body>
</html>