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
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
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
	<h1>Project: ${project.title }</h1>
	<h4>Project Lead: ${project.user.firstName } </h4>
	<form:form action="/projects/${project.id }/tasks" method="post"
		modelAttribute="task">
		<div class="form-group">
			<form:label path="ticket">Add a task ticket for this team:</form:label>
			<form:errors path="ticket" cssClass="text-danger" />
			<form:input path="ticket" class="form-control" />
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	
	<c:forEach items = "${project.tasks }" var = "oneTask">
		<p>Added by ${oneTask.user.firstName } at <fmt:formatDate pattern="h:mma MMM d" value="${oneTask.createdAt}"/> </p>
		<p>${oneTask.ticket }</p>
	
	
	</c:forEach>

</body>
</html>
