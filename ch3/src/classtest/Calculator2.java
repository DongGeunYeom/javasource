package classtest;

/* 클래스 - 멤버변수, 메소드를 내부에서 사용할 때는 이름만 사용해서 작성
 * 
 */

public class Calculator2 {
	
	int plus(int x, int y) {
		return x + y;
	}

	double avg(int x, int y) {
		double sum = plus(x, y);
		
		return sum / 2;
	}
	
	void execute() {
		double result = avg(7,10);
		println("실행 결과 = "+result);
	}
	
	void println(String message) {
		System.out.println(message);
	}

	
}
