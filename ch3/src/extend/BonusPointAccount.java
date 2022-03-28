package extend;

public class BonusPointAccount extends Account {
	
	private int bonusPoint;
	
	@Override
	int deposit(int amount) {
		//예금
		super.deposit(amount);
		// 보너스 포인트 = 예금액 * 0.1%
		bonusPoint += (int)(amount * 0.001);
		return bonusPoint;
	}
	
	public BonusPointAccount(String accountNo, String owner, int balance, int bonusPoint) {
		super(accountNo, owner, balance);
		this.bonusPoint = bonusPoint;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	
	
}
