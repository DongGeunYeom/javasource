package emp.action;

import java.sql.Connection;
import java.util.List;

import static emp.dao.JdbcUtil.*;

import java.util.Scanner;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;
import emp.service.EmpListService;
import emp.util.ConsoleUtil;

public class EmpListAction implements Action {

// ~~Action : 각 요청을 실질적으로 처리
	
	@Override
	public void execute(Scanner sc) throws Exception {
		// 서비스 객체 생성/호출
	
		EmpListService service = new EmpListService();
		List<EmpDTO> list = service.getEmpList();
		

		ConsoleUtil util = new ConsoleUtil();
		util.printEmpList(list);
		
	}

	
}
