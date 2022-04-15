package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberLoginService;

@AllArgsConstructor
public class MemberLoginAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password  = request.getParameter("current_password");
		
		MemberLoginService service = new MemberLoginService();
		MemberDTO loginDto = service.chkLogin(userid, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginDto", loginDto);
		
		return new ActionForward(path, true);	
	}

}
