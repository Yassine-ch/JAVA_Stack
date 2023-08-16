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
        <div class="row justify-content-center">
            <div class="col-lg-6">

                <!-- Title -->
                <h2 class="text-center mb-4">Edit ${show.title}</h2>

                <!-- Form Errors -->
                <p class="text-danger text-center"><form:errors path="show.*"/></p>

                <!-- Edit Form -->
                <form:form method="POST" action="/shows/${show.id}/update" modelAttribute="show" class="mb-4">
                    
                    <!-- Title -->
                    <div class="form-group">
                        <form:label path="title">Title:</form:label>
                        <form:input type="text" path="title" class="form-control"/>
                    </div>
                    
                    <!-- Network -->
                    <div class="form-group">
                        <form:label path="network">Network:</form:label>
                        <form:input type="text" path="network" class="form-control"/>
                    </div>
                    
                    <!-- Description -->
                    <div class="form-group">
                        <form:label path="description">Description:</form:label>
                        <form:input type="text" path="description" class="form-control"/>
                    </div>

                    <!-- Hidden Inputs -->
                    <form:input type="hidden" path="avgRating" value="${show.avgRating}"/>
                    <form:input type="hidden" path="userT" value="${user.id}"/>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between">
                        <input class="btn btn-success" type="submit" value="Update Show"/>
                        <a href="/shows/${show.id}" class="btn btn-primary">Cancel</a>
                    </div>
                </form:form>

                <!-- Delete Form -->
                <form action="/shows/${show.id}" method="post" class="text-center">
                    <input type="hidden" name="_method" value="delete">
                    <input class="btn btn-danger" type="submit" value="Delete Show">
                </form>

            </div>
        </div>
    </div>
</body>
</html>

