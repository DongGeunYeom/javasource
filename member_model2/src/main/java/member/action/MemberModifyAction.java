package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberLeaveService;
import member.service.MemberLoginService;
import member.service.MemberModifyService;
@AllArgsConstructor
public class MemberModifyAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String crPassword = request.getParameter("current_password");
		String nwPassword = request.getParameter("new_password");
		String cfPassword = request.getParameter("confirm_password");
		
		HttpSession session = request.getSession();
		MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
		String userid = loginDto.getUserid();
		
		MemberLoginService loginService = new MemberLoginService();
		
		if(loginService.chkLogin(userid, crPassword)==null){
			path = "/view/modifyForm.jsp";
		}else{
			MemberModifyService service = new MemberModifyService();
			if(nwPassword.equals(cfPassword)){
				if(service.modPassword(userid, cfPassword)){
					session.invalidate();
				}else{
					path = "/view/modifyForm.jsp";
				}
			}else{
				path="/view/modifyForm.jsp";
			}	
		}
		return new ActionForward(path, true);	
	}
}
