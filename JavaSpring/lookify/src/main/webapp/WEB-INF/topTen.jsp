<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="container">
		<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/dashboard">Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarDark"
				aria-controls="navbarDark" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse show" id="navbarDark">
				<ul class="navbar-nav me-auto mb-2 mb-xl-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/songs/new">Add New</a></li>
					<li class="nav-item"><a class="nav-link" href="/search/topTen">Top
							Songs</a></li>
				</ul>
				<form class="d-flex flex-row" action ="/search" method="post">
					<input class="form-control me-2" type="search" placeholder="Search" name="artist" value="${artist }"
						>
					<button class="btn btn-outline-light searchButton" type="submit">Search
						Artists</button>
				</form>
			</div>
		</div>
	</nav>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Rating</th>
      <th scope="col">Song Name</th>
      <th scope="col">Artist</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="song" items="${topTen }">
	<tr>
      <th scope="row"><c:out value="${song.rating }"/></th>
      <td><c:out value="${song.songName }"/></td>
      <td><c:out value="${song.artist }"/></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>

