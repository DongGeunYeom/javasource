package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import member.service.MemberCheckIdService;
@AllArgsConstructor
public class MemberCheckIdAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		MemberCheckIdService service = new MemberCheckIdService();
		
		String result = "";
		// 아이디가 중복이라면 false, undefined, null
		if(service.chkId(userid)){
			result = "true";
		} else {
			result = "false";
		}
		
		request.setAttribute("chkId", result);
		
		return new ActionForward(path, false);
	}
}
