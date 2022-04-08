<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션이 있는지 확인
	
	// String name = (String)session.getAttribute("name");
	/* String name = "";
	if(session.getAttribute("name")!=null){
		name = (String)session.getAttribute("name");
	} else{
		name = "세션 없음";
	} */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>현재 세션 값 : <%=name %> </h1> --%>
<%
	// 세션 전부 가져오기
	Enumeration<String> sessions = session.getAttributeNames();
	
	String name = "";
	while(sessions.hasMoreElements()){
		name = sessions.nextElement();
		if(name!=null){
			out.print("<h1>세션 확인 : " + name + "</h1>");
		}
		
	}

%>
<h1></h1>
<br />
<hr />
<h1>세션 테스트</h1>
<button type:"button" onclick="location.href='session_set.jsp'">세션 값 저장</button>
<button type:"button" onclick="location.href='session_delete.jsp'">세션 값 삭제</button>
<button type:"button" onclick="location.href='session_invalidate.jsp'">세션 값 초기화</button>
</body>
</html>