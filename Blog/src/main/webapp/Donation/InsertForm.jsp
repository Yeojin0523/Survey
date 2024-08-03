<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM</title>
</head>
<body>
	<div>
		<p><%= request.getAttribute("text") %></p>
	</div>
	<div>
		<form action = "DonationServlet" method="post">
			<textarea name="text" placeholder="내용을 입력하세요"></textarea>
			<button type="submit" id="insertFormBtn">확인</button>
		</form>
	</div>
</body>
</html>