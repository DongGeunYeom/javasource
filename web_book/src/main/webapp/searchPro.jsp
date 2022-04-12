<%@page import="book.dto.BookDTO"%>
<%@page import="book.dao.BookDAO"%>
<%@page import="book.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int code = Integer.parseInt(request.getParameter("code"));
	String writer = request.getParameter("writer");
	
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	BookDTO dto = dao.getRow(code, writer);
	
	request.setAttribute("dto", dto);
	pageContext.forward("searchResult.jsp");
%>