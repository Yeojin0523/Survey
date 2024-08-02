<%@ page import="donation.dao.DonationDao" %>
<%@ page import="donation.dto.DonationDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert Action</title>
</head>
<body>
	<%
	String text = request.getParameter("text");
			
		DonationDto dto = new DonationDto();
		dto.setText(text);
		
		// insert 메서드 호출
		DonationDao dao = new DonationDao();
		dao.insertDonation(dto);
		
		response.sendRedirect("list.jsp");
	%>
</body>
</html>