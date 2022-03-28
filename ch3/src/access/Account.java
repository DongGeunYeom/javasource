package access;

/* 접근 제한자 
 * - 객체 생성을 막아야 하는 경우
 * - 특정 메소드 호출을 못하도록 하는 경우
 * - 객체의 속성을 외부에서 함부로 변경하지 못하도록 하는 경우
 * - 종류 : private < default(package) < protected < public
 * 		  : default : 접근제한자를 안 붙이면 됨
 * 
 * - 클래스의 접근 제한
 * - public(같은 패키지, 다른 패키지 다 허용), default(같은 패키지)
 * 
 * - 멤버 변수의 접근제한(접근제한자 모두 사용가능)
 * - private : 같은 패키지건 다른 패키지건 상관없이 멤버변수 사용불가
 * 			 : 속성의 값 변경을 위해서는 메소드를 통해서만 제공하고 
 * 			   직접적으로 변경하는 것은 허용하지 않기 위해 사용
 * 
 */

 public class Account {
	// 속성 : 계좌번호, 소유자, 잔액
	
	private String depNumber;
	private String depHost;
	private int balance;
	
	
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
	
	// getter 메소드
	// private으로 설정된 변수에 대해서 외부에서 직접 접근은 불가능한 상황
	// 해당 변수값을 리턴하는 기능
	
	public String getAccountNo() {
		return depNumber;
	}
	
	public String getAccountHost() {
		return depHost;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// setter 메소드
	// 직접 변경하지 말고 메소드를 통해서 변경(매개값의 유효성을 검증한 후 변경)
	
	public void setAccountNo(String depNumber) {
		// 조건을 걸 수 있음 : 숫자 4자리 - 숫자 3자리
		this.depNumber = depNumber;
	}
	
	public void setAccountHost(String depHost) {
		this.depHost = depHost;
	}
	
	public void setAccountNo(int getBalance) {
		this.balance = balance;
	}

	
	
}
