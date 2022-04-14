<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// modifyForm에서 넘긴 값 가져오기	
	String crPassword = request.getParameter("current_password");
	String nwPassword = request.getParameter("new_password");
	String cfPassword = request.getParameter("confirm_password");
	
	MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
	String userid = loginDto.getUserid();
	
	// db 작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	String path = "";
	if(dao.isLogin(userid, crPassword)==null){
		out.print("<script>");
		out.print("alert('현재 비밀번호를 확인해 주세요.');");
		out.print("history.back();");
		out.print("</script>");
	}else{
		// new & comfrim password 값이 같은지 확인
		if(nwPassword.equals(cfPassword)){
			// 비밀번호 변경(changePassword)
			boolean result = dao.changePassword(userid, cfPassword);
			// 페이지 이동
			// 성공 - loginForm / 실패 - modifyForm
			// 세션 해제
			if(result){
				JdbcUtil.commit(con);
				session.invalidate();
				path = "loginForm.jsp";
			}else{
				JdbcUtil.rollback(con);
				path = "modifyForm.jsp";
			}
		}else{
			path="modifyForm.jsp";
		}
		JdbcUtil.close(con);
		response.sendRedirect(path);	
	}
%>