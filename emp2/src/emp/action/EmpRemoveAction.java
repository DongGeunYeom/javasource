package emp.action;

import java.util.Scanner;

import emp.dto.EmpDTO;
import emp.service.EmpRemoveService;
import emp.service.EmpRowService;
import emp.util.ConsoleUtil;

public class EmpRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		EmpRemoveService service = new EmpRemoveService();
		ConsoleUtil util = new ConsoleUtil();
		
		int empno = util.removeEmpno(sc);
		if(service.empRemove(empno)) {
			util.printRemoveSuccessMessage(empno);
		} else {
			util.printRemoveFailMessage(empno);
		}
	}
}	

