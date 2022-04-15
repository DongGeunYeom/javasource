package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;

public class MemberModifyService {
	public boolean modPassword(String userid, String cfPassword) {
	
	Connection con = getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	boolean result = dao.changePassword(userid, cfPassword);
	
	if(result) {
		commit(con);
	}else {
		rollback(con);
	}
	close(con);
	return result;
	}
}
	