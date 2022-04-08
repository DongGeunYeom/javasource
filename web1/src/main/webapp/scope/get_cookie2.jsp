<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 값 가져오기
	String cookies = request.getHeader("Cookie");
	String name= "", value="";
	if(cookies!=null){
		Cookie cookie[] = request.getCookies();
		
		for(int i = 0; i<cookie.length;i++){
			if(cookie[i].getName().equals("name")){
				name = cookie[i].getName();
				value = cookie[i].getValue();
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 명 : <%=name%></h3>
<h3>쿠키 값 : <%=value%></h3>
</body>
</html>