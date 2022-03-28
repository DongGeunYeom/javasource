package member.service;

import java.sql.Connection;
import static member.dao.JdbcUtil.*;

import member.dao.JdbcUtil;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberAddService {
	
	public boolean insertMember(MemberDTO insertDto) {
		boolean isAddSuccess = false;
		
		// 비즈니스 로직 처리 => 테이블에 member 추가
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		 
		if(dao.insert(insertDto)) {
			isAddSuccess = true;
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		
		// 비즈니스 로직 처리 결과 리턴(true or false)
		return isAddSuccess;
	}
}