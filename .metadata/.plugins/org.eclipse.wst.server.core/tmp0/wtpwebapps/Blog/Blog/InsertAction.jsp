<%@ page import="Blog.BlogDao" %>
<%@ page import="Blog.BlogDto" %>
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
	
		BlogDto dto = new BlogDto();
		dto.setText(text);
		
		// insert 메서드 호출
		BlogDao dao = new BlogDao();
		dao.insertBlog(dto);
		
		response.sendRedirect("list.jsp");
	%>
</body>
</html>