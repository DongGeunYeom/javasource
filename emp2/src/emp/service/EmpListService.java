package emp.service;

import static emp.dao.JdbcUtil.close;
import static emp.dao.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;

// ~~Service : 실질적인 비즈니스 로직을 처리
public class EmpListService {
	public List<EmpDTO> getEmpList(){
		
		Connection con = getConnection();
		EmpDAO dao = new EmpDAO(con);
		List<EmpDTO> list= dao.getList();
		 
		 close(con);
		 
		 return list;
	}

}
