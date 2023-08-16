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
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6" style="background-color: #0A4B6C; padding: 20px; border-radius: 5px;">
			
				<h1>Register</h1>
			    <p style="color: red;"><form:errors path="user.*"/></p>
			    
			    <form:form method="POST" action="/users" modelAttribute="user">
			        <div class="form-group">
			            <form:label path="name" class="form-label">Name:</form:label>
			            <form:input type="text" path="name" class="form-control" />
			        </div>
			        <div class="form-group">
			            <form:label path="email" class="form-label">Email:</form:label>
			            <form:input type="email" path="email" class="form-control"/>
			        </div>
			        <div class="form-group">
			            <form:label path="password" class="form-label">Password:</form:label>
			            <form:password path="password" class="form-control"/>
			        </div>
			        <div class="form-group">
			            <form:label path="passwordConfirmation" class="form-label">Password Confirmation:</form:label>
			            <form:password path="passwordConfirmation" class="form-control"/>
			        </div>
			        <input type="submit" value="Register!" class="btn btn-primary"/>
			    </form:form>
			</div>
		
		
			<div class="col-md-6" style="background-color: #75CCF7; padding: 20px; border-radius: 5px;">
			    <h1>Log In</h1>
			    <p style="color: red;"><c:out value="${error}" /></p>
			    
			    <form method="post" action="/login">
			        <div class="form-group">
			            <label for="email" class="form-label">Email</label>
			            <input type="text" id="email" name="email" class="form-control"/>
			        </div>
			        <div class="form-group">
			            <label for="password" class="form-label">Password</label>
			            <input type="password" id="password" name="password" class="form-control"/>
			        </div>
			        <input type="submit" value="Login!" class="btn btn-primary"/>
			    </form>
			</div>
		</div>
    </div>
</body>
</html>

