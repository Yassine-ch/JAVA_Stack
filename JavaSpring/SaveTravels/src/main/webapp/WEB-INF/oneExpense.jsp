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
		<div class="d-flex justify-content-between align-items-baseline">
			<h1>Expense Details</h1>
			<a href="/expenses">Go back</a>

		</div>
		<p>
			Expense Name:
			<c:out value="${expense.name}" />
		</p>
		<p>
			Expense Description:
			<c:out value="${expense.description}" />
		</p>
		<p>
			Vendor:
			<c:out value="${expense.vendor}" />
		</p>
		<p>
			Amount Spent:
			<c:out value="${expense.amount}" />
		</p>
	</div>
   
</body>
</html>

