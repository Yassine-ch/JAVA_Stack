<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Project Details</h1>
	<p>Project: ${project.title }</p>
	<p>Description: ${project.description }</p>
	<p>
		Due Date:
		<fmt:formatDate pattern="d/M/Y" value="${project.date}" />
	</p>
            <c:if test="${project.users.contains(user) || project.user.id == user.id	}">
	<form action="/projects/${project.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete"
			class="btn btn-outline-primary col-md-14 offset-md-4">
	</form>
	<button class="btn btn-outline-primary col-md-14 offset-md-4">
		<a href="/projects/${project.id}/tasks">See Tasks </a>
	</button>
	</c:if>

</body>
</html>
