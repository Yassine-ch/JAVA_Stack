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
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>Welcome, <c:out value="${user.name}" />!</h1>
            <div>
                <!-- Add Show and Log Out buttons -->
                <a href="/shows/new" class="btn btn-success mr-2">Add Show</a>
                <a href="/logout" class="btn btn-primary">Log Out</a>
            </div>
        </div>

        <!-- Display the error message, if any -->
        <p class="text-danger"><c:out value="${error}" /></p>

        <table class="table table-hover table-bordered">
            <thead class="thead-dark" style="background-color: #75CCF7;">
                <tr>
                    <th scope="col">Show</th>
                    <th scope="col">Network</th>
                    <th scope="col">AVG Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${shows}" var="s">
                    <tr>
                        <td><a href="/shows/${s.id}">${s.title}</a></td>
                        <td>${s.network}</td>
                        <td>${s.avgRating}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

