<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>donationDisplay</title>
</head>
<body>
	<h1>${text}</h1>
	<form action="your_form_action" method="post">
	text : <input type="text" name="text" value="${text}">
	<input type="submit" value="submit">
	</form>
</body>
</html>