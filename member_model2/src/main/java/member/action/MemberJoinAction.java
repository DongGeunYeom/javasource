package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberJoinService;

@AllArgsConstructor
public class MemberJoinAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		String password = request.getParameter("password");
		String cfPassword = request.getParameter("confirm_password");
		
		if(password.equals(cfPassword)){
			dto.setUserid(request.getParameter("userid"));
			dto.setPassword(cfPassword);
			dto.setName(request.getParameter("name"));
			dto.setGender(request.getParameter("gender"));
			dto.setEmail(request.getParameter("email"));
		}else{
			path = "/view/joinForm.jsp";
		}
		
		MemberJoinService service = new MemberJoinService();
		boolean result = service.join(dto);
		
		if(result) {
			HttpSession session = request.getSession();
			session.invalidate();
		}else {
			path = "/view/joinForm.jsp";
		}
		return new ActionForward(path, true);
	}
}
