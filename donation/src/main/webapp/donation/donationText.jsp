<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>donationDisplay</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty donation}">
            <h1>${donation.text}</h1>
        </c:when>
        <c:otherwise>
            <h1>No data found</h1>
        </c:otherwise>
    </c:choose>
    <form action="donation_form_action" method="get">
                기부하기 : <input type="text" name="text" value="금액을 입력하세요">
                <input type="submit" value="추가">
    </form>
</body>
</html>
