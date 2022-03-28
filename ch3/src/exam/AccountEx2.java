package exam;

import java.util.Arrays;
import java.util.Scanner;

import classtest.Account;

public class AccountEx2 {
	// 멤버변수
	private static Account2[] accountArray = new Account2[100];
	private static Scanner sc = new Scanner(System.in);
	static int size = accountArray.length;

	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");			
			System.out.println("-----------------------------------------------");
			System.out.printf("선택  >> ");

			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo ==1) {
				// 계좌생성
				createAccount();
				
			} else if(selectNo ==2) {
				// 계좌목록 보기
				accountList();
				
			} else if(selectNo ==3) {
				// 입금
				deposti();
				
			} else if(selectNo ==4) {
				// 출금
				withdraw();
				
			} else if(selectNo ==5) {
				// 종료
				run = false;
			}		
		} 
	} // main end
	
	private static void createAccount() {
		// 계좌생성
		// ano, owner, balance 입력받기
		
		System.out.printf("계좌번호 >> ");
		String ano = sc.nextLine();
		
		System.out.printf("계좌주 >> ");		
		String owner = sc.nextLine();

		System.out.printf("예금액 >> ");
		int balance = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		// Account2 객체 생성		
		// 배열에 담아주기	
		for(int i = 0; i < size; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = new Account2(ano, owner, balance);
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		// 지금까지 생성된 모든 계좌목록 보여주기
		System.out.println("------------------------");
		System.out.println("계좌번호     계좌주     잔액");
		System.out.println("------------------------");

		for(int i = 0; i < size; i++) {
			if(accountArray[i] != null) {
				System.out.printf("%s\t%s\t%d\n",
						accountArray[i].getAno(),
						accountArray[i].getOwner(),
						accountArray[i].getBalance());
				System.out.println();
			} else {
				break;
			}
		}		
	}
	
	private static void deposti() {
		// 예금하기
		// 계좌번호 입력 받기
		System.out.printf("계좌번호 >> ");
		String ano = sc.nextLine();
		
		// 입력 받은 계좌번호가 배열에 들어 있는지 확인
		Account2 account = findAccount(ano);
		
		if(account == null) {
			System.out.println("올바른 계좌번호를 입력해주세요.");
			
		} else {
			// 잔액 = 잔액 - 예금액
			// account가 null 이 아니면 입금 처리
			// 입금액 입력 받기
			System.out.printf("입금액 >> ");
			int amount = Integer.parseInt(sc.nextLine());
			account.setBalance(amount+account.getBalance());	
		}
	}
 

	private static void withdraw() {
		// 출금
		
		System.out.printf("계좌번호 >> ");
		String ano = sc.nextLine();
		
		// 입력 받은 계좌번호가 배열에 들어 있는지 확인
		Account2 account = findAccount(ano);
		
		if(account == null) {
			System.out.println("올바른 계좌번호를 입력해주세요.");
			
		} else {
			// account가 null 이 아니면 출금 처리
			// 출금액 입력 받기
			System.out.printf("출금액 >> ");
			int amount = Integer.parseInt(sc.nextLine());
			if(account.getBalance() >=amount) {
				account.setBalance(account.getBalance()-amount);	
			} else {
				System.out.println("잔액 부족");	
			}
		}
	}
	
	private static Account2 findAccount(String ano) {
		// Account2 배열에서 ano와 동일한 Account 찾기
		
		// for 문
		for(int i = 0; i < size; i++) {
			
			// if문(null 아닌 경우만)
			if(accountArray[i].getAno() != null){
				if(accountArray[i].getAno().equals(ano)) {
					// 찾은 account2를 리턴
					return accountArray[i];	
				}
			} 
		}
		return null;
    }
}
