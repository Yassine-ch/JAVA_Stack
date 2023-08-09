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
   	<div class="w-50 mx-auto mt-3">
		<h1>Edit Burger</h1>
		
		<a href="/">Go back</a>
		<form:form action="/burgers/edit/${oneBurger.id }" method="put" modelAttribute="oneBurger">
			<div class="mb-3">
				<form:label path="name" class="form-label">Burger Name</form:label>
			
				<form:input path="name" type="text" class="form-control" />
				<p class="form-text text-danger"><form:errors path="name"/></p>
			</div>
			<div class="mb-3">
				<form:label path="restaurantName" class="form-label">Restaurant Name</form:label>
				<form:input path="restaurantName" type="text" class="form-control" />
				<p class="form-text text-danger"><form:errors path="restaurantName"/></p>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input path="rating" type="number" class="form-control" />
				<p class="form-text text-danger"><form:errors path="rating"/></p>
			</div>
			<div class="mb-3">
				<form:label path="notes" class="form-label">Notes</form:label>
				<form:textarea path="notes" class="form-control" rows="3"></form:textarea>
				<p class="form-text text-danger"><form:errors path="notes"/></p>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>
	</div>
</body>
</html>

