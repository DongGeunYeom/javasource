package exam;

public class Account2 {
	// 계좌번호(ano)
	// 계좌주(owner)
	// 잔액(balance)
	private String ano;
	private String owner;
	private int balance;
	
	// 생성자 (3개의 멤버변수 초기화)
	public Account2(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	// getter, setter 메소드 작성
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}
