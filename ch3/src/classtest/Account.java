package classtest;

public class Account {
	// 속성 : 계좌번호, 소유자, 잔액
	
	String depNumber;
	String depHost;
	int balance;
	
	
	public Account(String depNumber, String depHost, int balance) {
		super();
		this.depNumber = depNumber;
		this.depHost = depHost;
		this.balance = balance;
	}
	
	// 기능 : 입금한다, 출금한다

	
	int deposit(int amount) {
		return this.balance += amount;
	}
	
	int withdraw(int amount) {
		return this.balance -= amount;
	}

}
