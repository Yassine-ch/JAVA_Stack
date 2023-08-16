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
<h2>Register</h2>

<div class="container">
	<form:form class="user-form" action="/users" method="post" modelAttribute="user">
		<div class="form-group">
			<form:label path="name"> Name</form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name" />
		</div>

		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:errors path="email"/>
			<form:input type="email" class="form-control" path="email" />
		</div>

		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:errors path="password"/>
			<form:password class="form-control" path="password" />
		</div>
		<div class="form-group">
			<form:label path="passwordConfirmation">Confirm Password</form:label>
			<form:errors path="passwordConfirmation"/>
			<form:password class="form-control" path="passwordConfirmation" />
		</div>
		<input type="submit" value="Register!"/>
	</form:form>
	<form action="/login" class="user-form" method="post">
		<h2>Login</h2>
		<p style="color: red;"><c:out value="${error}" /></p>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" name="email" id="email" class="form-control" />
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" name="password" id="password" class="form-control" />
		</div>
		<input type="submit" value="Login!"/>
	</form>
</div>
</body>
</html>

