<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>insert title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

	<h1>Welcome ${user.firstName }</h1>
	<h3>All Projects</h3>
				<button type="button"
		class="btn btn-outline-primary col-md-2 offset-md-9">
			<a href="/logout">Logout</a>

	</button>
		<button type="button" class="btn btn-outline-primary col-md-2 offset-md-9">
		<a href="/projects/new">Create a Project</a> 


		</button>

	<table class="table">
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allProjects }" var="oneProject">
            <c:if test="${!oneProject.users.contains(user) && oneProject.user.id != user.id }">
			
				<tr>
					<td> <a href="/projects/${oneProject.id }" >${oneProject.title }</a> </td>
					<td>${oneProject.user.firstName }</td>
					<td><fmt:formatDate pattern="MMM d" value="${oneProject.date}"/></td>
					<td>
					<a href = "/projects/${oneProject.id }/join" >Join Team</a>
				

					</td>
	
				</tr>
				</c:if>
			</c:forEach>
			


		</tbody>
	</table>
		<h3>Your Projects</h3>
	
		<table class="table">
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allProjects }" var="oneProject">
            <c:if test="${oneProject.users.contains(user) || oneProject.user.id == user.id	}">
			
				<tr>
					<td> <a href="/projects/${oneProject.id }" >${oneProject.title }</a> </td>
					<td>${oneProject.user.firstName }</td>
					<td> <fmt:formatDate pattern="MMM d" value="${oneProject.date}" /></td>
					<td>
					<c:if test="${oneProject.user.id == user.id }">
					<a href = "/projects/${oneProject.id }/edit" >Edit</a>
					
					</c:if>
					<c:if test="${oneProject.user.id != user.id }">
					
					<a href = "/projects/${oneProject.id }/leave" >Leave Team</a>
					</c:if>
					
					
				

					</td>
	
				</tr>
				</c:if>
			</c:forEach>
			


		</tbody>
	</table>


</body>
</html>
