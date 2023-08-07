<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script defer src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="w-50 mx-auto mt-3">
		<h1>Send an Omikuji</h1>
		<form action="/process" method="post" class="border p-3 rounded">
			<div class="mb-3">
				<label class="form-label">Pick any number from 5 to 25</label>
				<input type="number" name="year" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any city</label>
				<input type="text" name="city" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any real person</label>
				<input type="text" name="person" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter professional endeavor of hobby:</label>
				<input type="text" name="hobby" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter any type of living thing.</label>
				<input type="text" name="livingThing" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Say something nice to someone:</label>
				<textarea class="form-control" name="message" rows="3"></textarea>
			</div>
			<div class="form-text mb-2">Send and show a friend</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</html>