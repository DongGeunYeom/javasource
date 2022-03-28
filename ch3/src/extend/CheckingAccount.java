package extend;

public class CheckingAccount extends Account{
	// Account + 체크카드 기능
	
	private String cardNo; //체크카드 번호

	public CheckingAccount(String accountNo, String owner, int balance, String cardNo) {
		super(accountNo, owner, balance);
		this.cardNo = cardNo;
	}

	// 직불카드 사용액을 지불한다
	// 매개인자로 직불카드 번호와 사용액을 받아서 카드 번호 일치 여부 및
	// 은행 잔고와 비교한 후 지불
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	void pay(String cardNo, int amount) {
		if(!getCardNo().equals(cardNo)) {
			System.out.println("카드번호가 일치하지 않습니다.");
			return;
		} else {
			if(getBalance() < amount) {
				System.out.println("잔액이 부족합니다.");
			} else {
				System.out.println(amount+"원을 인출합니다.");
				withdraw(amount);
				return;
			}
		}	
	}
}

