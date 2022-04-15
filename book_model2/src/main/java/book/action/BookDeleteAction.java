package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookDeleteService;

public class BookDeleteAction implements Action {
	
	private String path;
	
	public BookDeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// getParameter
		int code = Integer.parseInt(request.getParameter("code"));
		
		// service 호출
		BookDeleteService service = new BookDeleteService();
		if(!service.remove(code)) {
			path = "/delete.jsp";
		}
		return new ActionForward(path, true);
	}

}
