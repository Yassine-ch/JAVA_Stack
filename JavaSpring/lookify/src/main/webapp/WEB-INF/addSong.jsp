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
<body>
   <div class="d-flex flex-column align-items-center">
		<h1>Add a song</h1>
		<form:form action="/songs/new" method="post" modelAttribute="lookify">

			<p>
				<form:errors path="songName" class="error" />
			</p>
			<p>
				<form:errors path="artist" class="error" />
			</p>
			<p>
				<form:errors path="rating" class="error" />
			</p>


			<p>
				<form:label path="songName">Song Name:</form:label>
				<form:input path="songName" type="text" />
			</p>
			<p>
				<form:label path="artist">Artist:</form:label>
				<form:input path="artist" type="text" />
			</p>
			<p>
				<form:label path="rating">Rating: </form:label>
				<form:input type="number" path="rating" />
			</p>
	
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>

