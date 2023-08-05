<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Receipt</title>
</head>
<body>
<h1>Hopper's Receipt</h1>
<c:forEach items = "${hopperList }" var="receipt">


<c:out value = "${receipt.name }" /><br>
<c:out value = "${receipt.itemName }" /><br>
<c:out value = "${receipt.price }" /><br>
<c:out value = "${receipt.description }" /><br>
<c:out value = "${receipt.vendor }" /><br>

</c:forEach>

</body>
</html>