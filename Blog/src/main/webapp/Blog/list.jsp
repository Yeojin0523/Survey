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
<script src="list.js"></script>
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
					<h1>기부하기</h1>
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
			<tr>
				<td>
					<table class="category_table">
						<tr>
							<td>r</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h1>기부하기. ㅇㅇㅇ</h1>
				</td>
			</tr>
			<tr>
				<td>
					<div class="content">
						<div class="donateList">
							<table class="inner_table">
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

									while (rs.next()) {
										out.println("<tr>");
										out.println("<td>" + rs.getInt("seq") + "</td>");
										out.println("<td>" + rs.getString("text") + "</td>");
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


	<div class="button_area">
		<button id="insertBtn">추가</button>
	</div>
</body>
</html>

