<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// leaveForm 에서 보낸 값 가져오기(userid, password)
	String password = request.getParameter("current_password");
	String userid = request.getParameter("userid");

	// db작업(leave)
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	boolean result = dao.leave(userid, password);
	
	String path = "";
	// 탈퇴성공 - 세션해제
	// 페이지이동 - 성공 : index.jsp 실패 : leaveForm.jsp
	if(result){
		JdbcUtil.commit(con);
		session.invalidate();
		path = "/index.jsp";
	}else{
		JdbcUtil.rollback(con);
		path = "leaveForm.jsp";
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>