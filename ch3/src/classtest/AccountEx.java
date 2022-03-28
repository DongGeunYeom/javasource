package classtest;

public class AccountEx {

	public static void main(String[] args) {

		Account bal1 = new Account("111-11-123", "홍길동", 10000);
		System.out.println(bal1.depHost+" 현재 잔액 : "+bal1.withdraw(5000));
		
		
		Account bal2 = new Account("111-111-123", "성춘향", 20000);
		System.out.println(bal2.depHost+" 현재 잔액 : "+bal2.deposit(100000));

		
		
	}

}
