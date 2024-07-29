<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
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
<title>my blog</title>
<link rel="stylesheet" href="list.css">
</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="top_gnb_area"></div>
			<div class="top_area">
				<div class="logo_area">
					<h1>여기에 로고 넣기</h1>
				</div>
				<div class="donate_area">
					<h3 id="donate-link">기부하기</h3>
				</div>

				<div class="mail_area">
					<h1>메일 보내기</h1>
				</div>
				<div class="login_area">
					<h1>로그인하기</h1>
					<!-- 로그인 안한 상태 -->
					<c:if test="${memeber == null}">
						<div class="loginBtn">
							<a href="">로그인</a>
						</div>
						<span><a href="">회원가입</a></span>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="frame">
		<table class="outer_table">
			<tr class="category">
				<td>전체</td>
				<td>어린이</td>
				<td>지구촌</td>
			</tr>
			<tr class="list">
				<td>
					<h1>최신순</h1>
				</td>
				<td>
					<h1>오래된순</h1>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<div class="content">
						<div class="donateList">
							<table class="inner_table">
								<!--  
								<tr>
									<th>id</th>
									<th>text</th>
								</tr>
								-->
								<%
								try {
									Class.forName("oracle.jdbc.driver.OracleDriver");
									conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##systemid", "systempwd");
									String sql = "SELECT * FROM blog";
									pstmt = conn.prepareStatement(sql);
									rs = pstmt.executeQuery();
									int count = 0;
									
									while (rs.next()) {
										if(count % 4 == 0){
											out.println("<tr>");
										}
										 out.println("<td>");
	                                        out.println("<div class='each-content' onclick='goToInsertForm()'>");
	                                        out.println("<span>" + rs.getInt("seq") + "</span>");
	                                        out.println("<span>" + rs.getString("text") + "</span>");
	                                        out.println("</div>");
	                                        out.println("</td>");
	                                        count++;
										
										if(count % 4 == 0){
										out.println("</tr>");
										}
									}
									if (count % 4 != 0) {
										out.println("</tr>");
									}
								} catch (Exception e) {
									e.printStackTrace();
								} finally {
									try {
										if (rs != null)
									rs.close();
										if (pstmt != null)
									pstmt.close();
										if (conn != null)
									conn.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								%>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<script src="list.js"></script>
</body>
</html>

