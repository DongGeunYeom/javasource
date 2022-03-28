package emp.action;

import java.util.Scanner;

// action : 사용자의 요청들을 제어하는 action 클래스들이 정의
public interface Action {
	void execute(Scanner sc) throws Exception;
	
	
}
