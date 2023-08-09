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
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneExpense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${oneExpense.id}"><c:out
									value="${oneExpense.name}" /></a></td>
						<td><c:out value="${oneExpense.vendor}" /></td>
						<td><fmt:formatNumber value="${oneExpense.amount}"
								type="currency" /></td>
						<td><a href="/expenses/edit/${oneExpense.id }">Edit</a></td>
						<td>
							<form action="/expenses/${oneExpense.id}" method="post">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" value="Delete" class="btn btn-danger"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<h2>Add an Expense:</h2>
		<form:form action="/expenses/new" method="post"
			modelAttribute="newExpense">
			<div class="mb-3">
				<form:label path="name" class="form-label">Expense Name:</form:label>
				<form:input path="name" type="text" class="form-control" />
				<p class="form-text text-danger">
					<form:errors path="name" />
				</p>
			</div>
			<div class="mb-3">
				<form:label path="vendor" class="form-label">Vendor:</form:label>
				<form:input path="vendor" type="text" class="form-control" />
				<p class="form-text text-danger">
					<form:errors path="vendor" />
				</p>
			</div>
			<div class="mb-3">
				<form:label path="amount" class="form-label">Amount:</form:label>
				<form:input path="amount" type="number" step="0.01"
					class="form-control" />
				<p class="form-text text-danger">
					<form:errors path="amount" />
				</p>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description</form:label>
				<form:textarea path="description" class="form-control" rows="3"></form:textarea>
				<p class="form-text text-danger">
					<form:errors path="description" />
				</p>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>

