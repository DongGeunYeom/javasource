package member.service;

import member.dao.MemberDAO;
import member.dto.MemberDTO;
import static member.dao.JdbcUtil.*;

import java.sql.Connection;

public class MemberLoginService {
	public MemberDTO chkLogin(String userid, String password) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO loginDto = dao.isLogin(userid, password);
		
		close(con);
		return loginDto;
	}
}