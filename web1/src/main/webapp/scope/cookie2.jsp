<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%
	Cookie c = new Cookie("name", "hong");
	c.setMaxAge(600); // 초
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 데이터 저장</h3>
<a href="get_cookie2.jsp">쿠키 값 확인</a>
</body>
</html>