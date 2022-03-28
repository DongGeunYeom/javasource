package extend;

public class CheckingTrafficCardAccount extends CheckingAccount{
	// Account + 체크카드 + 교통카드 기능(t/f) : hasTrafficCard

	private boolean hasTrafficCard;
	
	public CheckingTrafficCardAccount(String accountNo, String owner, int balance, String cardNo, boolean hasTrafficCard) {
		super(accountNo, owner, balance, cardNo);
		this.hasTrafficCard = hasTrafficCard;
	}
	
	void payTrafficCard(String cardNo, int amount) {
		if(!hasTrafficCard) {
			System.out.println("이 카드는 교통카드기능이 없습니다.");
			return;
		} 
		pay(cardNo, amount);
		return;
	}
	
	
	// 교통비 지불한다. - payTrafficCard()
	// cardNo, 교통카드 사용액을 매개 변수로 받는다
	// 교통카드 기능이 있는지 확읺나다.
	// 부모의 pay 호출
	
}
