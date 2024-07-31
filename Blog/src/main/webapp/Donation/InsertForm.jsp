<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부하기</title>
</head>
<body>
    <div>
    	<p><%= request.getAttribute("text") %></p>
    </div>
    <div>
        <form action="InsertAction.jsp" method="post">
            <textarea name="text" placeholder="내용을 입력하세요" rows="4" cols="50"></textarea>
            <button type="submit" id="insertFormBtn">확인</button>
        </form>
    </div>
</body>
</html>
