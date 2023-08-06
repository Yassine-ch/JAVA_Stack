<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-center mt-5">You have visited <a href="/"><c:out value="${page}"/></a> <c:out value="${count}"/> time(s).</h1>
	<p class="text-center mt-5"><a href="/your_server">Test another visit?</a></p>
	<p class="text-center"><a href="/count-two/">Add 2 visits</a></p>
	<p class="text-center"><a href="/reset-counter/">Reset counter</a></p>
</body>
</html>