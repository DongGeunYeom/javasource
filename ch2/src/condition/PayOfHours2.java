package condition;

import java.util.Scanner;

public class PayOfHours2 {
	public static void main(String[] args) {
		// 사용자로부터 근무시간을 입력받기
		// 근무시간 중 8시간까지는 시간당 9800원 지급
		// 8시간을 초과하는 근무시근은 시간당 급여의 1.5배를 추가지급하는 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("근무시간을 입력해주세요");
		
		int time = sc.nextInt();
		int rate = 9800;
		int pay = 0;
		
		if(time > 8) {
			
			pay = (int)((time-8)*1.5*rate)+8*rate;
			
			System.out.println("귀하에게 초과근무가 발생하였습니다. 지급될 급여는 "+pay+"원 입니다.");
	
		} else  {	
			
			pay = time * rate;
			System.out.println("귀하에게 지급될 급여는 "+pay+"원 입니다.");
			
		}
		

	}

}
