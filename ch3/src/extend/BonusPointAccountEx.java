package extend;

public class BonusPointAccountEx {

	public static void main(String[] args) {
		// BonusPointAccount 객체 생성
		BonusPointAccount bpa = new BonusPointAccount("110-10", "홍길동", 10000, 1000);
		
		// 예금
		bpa.deposit(10000);
		
		// 보너스 포인트 출력
		System.out.println("현재 잔액 : "+bpa.getBalance());
		System.out.println("보너스 포인트 : "+bpa.getBonusPoint());
		
	}

}
