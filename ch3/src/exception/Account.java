package exception;

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
	
//	int withdraw(int amount) throws BalanceInsufficientException {
//		if(balance < amount) {
//			//예외 강제 발생
//			throw new BalanceInsufficientException("잔고부족 : "+(amount-balance)+" 부족");	
//		}
//		balance -= amount;
//		return balance;
	
	int withdraw(int amount) throws Exception {
		if(balance < amount) {
			//예외 강제 발생
			throw new Exception("잔고부족 : "+(amount-balance)+" 부족");	
		}
		balance -= amount;
		return balance;
	}

}
