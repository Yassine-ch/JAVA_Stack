<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Hopper's Receipt</title>
</head>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table tablecolor">
			<tbody>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
				<c:forEach var="oneFruit" items="${fruitsFromMyController}">
				<tr>
					<td scope="row"><c:out value="${oneFruit.name}"></c:out></td>
					<td scope="row"><c:out value="${oneFruit.price}"></c:out></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>