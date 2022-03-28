package member.service;
import static member.dao.JdbcUtil.*;
import java.sql.Connection;
import static member.dao.JdbcUtil.*;

import member.dao.JdbcUtil;
import member.dao.MemberDAO;
import member.dto.MemberDTO;
import member.util.ConsoleUtil;

public class MemberRemoveService {
	
	public boolean remove(int id) {
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
       if(dao.deleteMember(id)) {
    	   commit(con);
    	   isRemoveSuccess = true;
       } else {
    	   rollback(con);
       }
		close(con);
		return isRemoveSuccess;
	}
}
