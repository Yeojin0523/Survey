<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<% 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>my blog</title>
	<script src="list.js"></script>
</head>
<body>
<table width="800" border="1" align="center">
<tr>
	<th>id</th>
	<th>text</th>
</tr>
	<% 
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##systemid", "systempwd");
        String sql = "SELECT * FROM blog";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            out.println("<tr>");
            out.println("<td>" + rs.getInt("seq") + "</td>");
            out.println("<td>" + rs.getString("text") + "</td>");
            out.println("</tr>");
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
%>
</table>
<div>
	<button id="insertBtn">�߰�</button>
</div>
</body>
</html>

