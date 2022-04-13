<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// joinForm 에서 보낸 값 가져오기(userid, password)
	MemberDTO dto = new MemberDTO();
	String password = request.getParameter("password");
	String cfPassword = request.getParameter("confirm_password");
	String path = "";
	if(password.equals(cfPassword)){
		dto.setUserid(request.getParameter("userid"));
		dto.setPassword(cfPassword);
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
	}else{
		path = "joinForm.jsp";
	}

	// db작업(register)
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	boolean result = dao.register(dto);
	
	// 페이지이동 - 성공 : loginForm.jsp 실패 : joinForm.jsp
	if(result){
		JdbcUtil.commit(con);
		session.invalidate();
		path = "loginForm.jsp";
	}else{
		JdbcUtil.rollback(con);
		path = "joinForm.jsp";
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>