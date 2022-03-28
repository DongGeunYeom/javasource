package member.action;

import java.util.Scanner;

import member.dto.MemberDTO;
import member.service.MemberAddService;
import member.service.MemberModifyService;
import member.service.MemberRemoveService;
import member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil util = new ConsoleUtil();
		int id = util.printRemoveMessage(sc);
		
		MemberRemoveService service = new MemberRemoveService();
		
		if(service.remove(id)) {
			 util.printRemoveSuccessMessage();
		} else {
			 util.printRemoveFailMessage();
		}
	}	
}

