package condition;

import java.util.Scanner;

public class BankApp2 {
	public static void main(String[] args) {
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int balance = 0; //잔고


		while(run) {
		System.out.println("-------------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("-------------------------------------");	
		System.out.printf("선택> ");
		
		int menu = sc.nextInt();

		
		switch (menu) {
		case 1:
			// 예금액 입력 받은 후 잔고에 추가
			System.out.print("예금액 >> ");
			balance += sc.nextInt();
			break;
		case 2:
			System.out.print("출금액 >> ");
			balance -= sc.nextInt();
			break;
		case 3:
			//잔고 출력
			System.out.printf("귀하의 잔고는 %d원 입니다.\n",balance);
			break;
		case 4:
			run = false;
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 번호를 입력해 주세요.");
			break;
			
			}
		
		}
		sc.close();	
	}
}