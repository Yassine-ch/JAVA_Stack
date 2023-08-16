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
    <div class="d-flex flex-column align-items-end">
    <p><a href="/" class="btn btn-primary">Back To Dashboard</a></p>
     </div>
                  <c:if test="${show.userT.id == user.id}">
            <div class="d-flex flex-column align-items-end">
                <p><a href="/shows/${show.id}/edit" class="btn btn-warning">Edit This Show</a></p>
                
            </div>
          
        </c:if>
        <h6>posted By : ${show.userT.name }</h6>
        <!-- Show Info Section -->
        <div class="d-flex flex-column align-items-center mb-5">
            <h3><c:out value="${show.title}" /></h3>
            <h5>Network: <c:out value="${show.network}" /></h5>
            <h5>Average Rating: <c:out value="${show.avgRating}" /></h5>
            
   
            
            <hr class="w-100">
        </div>

        <!-- Ratings Table Section -->
        <h3 class="text-center mb-4">Users who rated this show:</h3>
        <table class="table ">
             <thead class="thead-dark" style="background-color: #75CCF7;">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Rating</th>
                </tr>
            </thead>
            <tbody class="tbody-dark" style="background-color: white;">
                <c:forEach items="${show.reviews}" var="s">
                    <tr>
                        <td>${s.user.name}</td>
                        <td>${s.rating}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Rate Show Section -->
        <div class="mt-5">
            <h3 class="text-center mb-4">Rate this Show</h3>
            
            <!-- Display errors with Bootstrap styling -->
            <p class="text-danger text-center"><c:out value="${error}" /></p>
            <p class="text-danger text-center"><form:errors path="review.*"/></p>
            
            <form:form method="POST" action="/shows/${show.id}/review" modelAttribute="review" class="d-flex flex-column align-items-center">
                <div class="form-group">
                    <form:label path="rating">Rating:</form:label>
                    <form:select path="rating" class="form-control w-auto">
                        <form:option value="5">5</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="1">1</form:option>
                    </form:select>
                </div>

                <form:input type="hidden" path="user" value="${user.id}" />
                <form:input type="hidden" path="show" value="${show.id}" />

                <!-- Submit Button -->
                <div class="form-group">
                    <input class="btn btn-primary" type="submit" value="Submit Rating"/>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>

