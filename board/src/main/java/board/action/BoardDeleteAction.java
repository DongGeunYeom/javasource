package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardDeleteService;

public class BoardDeleteAction implements Action {

	private String path;
	
	public BoardDeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno")); 
		String password = request.getParameter("password");
		
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");

		BoardDeleteService service = new BoardDeleteService();
		boolean result = service.remove(bno, password);
		
		if(!result) {
			path = "/view/qna_board_pwdCheck.jsp?bno="+bno+"&page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}	
		return new ActionForward(path, true);			
	}
}
