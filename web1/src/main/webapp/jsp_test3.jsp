<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 주석 -->
<%-- jsp 주석 --%>
<%
	//1 ~ 100 합계 구한 뒤 출력
	int sum = 0;
	for(int i = 0; i<101; i++){
		sum += i;
	}
	// out.print("<h3>"+sum+"</h3>");
%>
<h3><%=sum %></h3>
</body>
</html>