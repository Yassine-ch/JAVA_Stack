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
            <div class="col-md-6">
                <h1 class="text-center">Create a new show</h1>
                
                <!-- Display errors with better Bootstrap styling -->
                <p class="text-danger text-center"><form:errors path="show.*"/></p>
                
                <!-- FORM TO CREATE A NEW SHOW -->
                <form:form method="POST" action="/shows" modelAttribute="show">
                    
                    <!-- Title Field -->
                    <div class="form-group">
                        <form:label path="title">Title:</form:label>
                        <form:input type="text" path="title" class="form-control"/>
                    </div>

                    <!-- Network Field -->
                    <div class="form-group">
                        <form:label path="network">Network:</form:label>
                        <form:input type="text" path="network" class="form-control"/>
                    </div>

                    <!-- Description Field -->
                    <div class="form-group">
                        <form:label path="description">Description:</form:label>
                        <form:input type="text" path="description" class="form-control"/>
                    </div>

                    <!-- Hidden Field -->
                    <form:input type="hidden" path="userT" value="${user.id}"/>

                    <!-- Submit Button -->
                    <div class="form-group text-center">
                        <input type="submit" value="Add TV Show" class="btn btn-primary"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>

