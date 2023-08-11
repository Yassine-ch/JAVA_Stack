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
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<h1 class="display-5">Students:</h1>
			<form:form action="/students" modelAttribute="student" method="POST" class="p-3 w-50">
				<div class="input-group mb-3">
					<span class="input-group-text">First Name:</span>
					<form:input type="text" path="firstName" class="form-control" />
				</div>
				<div><form:errors path="firstName" /></div>
				<div class="input-group mb-3">
					<span class="input-group-text">Last Name:</span>
					<form:input type="text" path="lastName" class="form-control" />
				</div>
				<div><form:errors path="lastName" /></div>
				<input type="submit" value="Create" class="btn btn-sm btn-primary" />
			</form:form>
		</div>
	</div>

</body>

</html>

