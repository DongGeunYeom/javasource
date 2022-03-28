package emp.controller;

import java.util.Scanner;

import emp.action.Action;

// controller : 특정 메뉴가 선택되었을 때 요청을 직접 받아서
// 				흐름을 제어하는 클래스 정의
public class EmpController {
	public void processRequest(Action action, Scanner sc) {
		
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
