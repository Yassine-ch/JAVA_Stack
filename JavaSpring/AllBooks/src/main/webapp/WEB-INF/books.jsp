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
   <h1>All the books</h1>
   <c:forEach items="${bookList }" var="oneBook">
   
   <h3>

   </h3>
   <table class="table" >
     <tr>
    <th scope="col">title</th>
    <th scope="col">Language</th>
    <th scope="col"># Pages</th>
  </tr>
     <tr scope="row">
    <td> <a href="/books/${oneBook.id }">  Title: ${oneBook.title }</a></td>
    <td>${oneBook.language }</td>
    <td>${oneBook.numberOfPages }</td>
  </tr>
   </table>

   </c:forEach>
</body>
</html>

