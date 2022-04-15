package member.action;

public class MemberActionFactory {

	private static MemberActionFactory maf;
	
	private MemberActionFactory() {}
	
	public static MemberActionFactory getInstance() {
		if(maf ==null) {
			maf = new MemberActionFactory();
		}
		return maf;
	}
	
	Action action = null;
	public Action action(String cmd) {
		// Action 생성시 path 지정(작업이 성공할 경우 움직일 페이지)
		if(cmd.equals("/login.do")) {
			action = new MemberLoginAction("/view/loginForm.jsp");
		}else if(cmd.equals("/logout.do")){
			action = new MemberLoginAction("/view/loginForm.jsp");
		}else if(cmd.equals("/leave.do")){
			action = new MemberLoginAction("/index.jsp");
		}else if(cmd.equals("/modify.do")){
			action = new MemberModifyAction("/view/loginForm.jsp");
		}else if(cmd.equals("/join.do")){
			action = new MemberJoinAction("/view/loginForm.jsp");
		}else if(cmd.equals("/checkId.do")){
			action = new MemberCheckIdAction("/view/checkId.jsp");
		}		
		return action;
	}
}
