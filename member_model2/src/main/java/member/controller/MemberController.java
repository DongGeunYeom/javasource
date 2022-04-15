package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;
import member.action.ActionForward;
import member.action.MemberActionFactory;

/**
 * Servlet implementation class BookController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 문자 인코딩(한글처리)
		request.setCharacterEncoding("utf-8");
		
		// requestUri 확인
		String cmd = request.getRequestURI(); // *.do
		
		// Action 생성 => BookActionFactory 이용
		MemberActionFactory maf = MemberActionFactory.getInstance();
		Action action = maf.action(cmd); 
		
		// 생성된 action에게 요청 넘기기
		ActionForward af = null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// af => path, 이동방식
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
