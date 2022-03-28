package classtest;

public class GoodsStock {
	// 속성 - 상품코드(P1010), 재고수량(25)
	
	String code;
	int stockNum;
	
	public GoodsStock() {
		// default 생성자
		super();		// TODO Auto-generated constructor stub
	}
	
	public GoodsStock(String code, int stockNum) {
		super();
		this.code = code;
		this.stockNum = stockNum;
	}

	public GoodsStock(String code) {
		super();
		this.code = code;
	}
	
	

	// 기능 - 재고추가, 재고감소
	// 메소드(==함수) : 어떤 기능을 가지고 있음
	// 리턴타입 메소드명(인자...){
	// 해야 할 일 명시
	//   }
	
	// 리턴타입 : 데이터타입(byte, short, int, long, char, float, double, boolean) 모두 가능
	//				 : 배열타입(byte[], short[], int[]...)
	//				 : 클래스, 인터페이스
	//				 : void - 가지고 갈 거 없음
	//				 : 메소드가 일을 끝내고 돌아갈 때 가지고 가야 할 데이터 타입
	// ex) int method1(){} : method1 일을 끝내고 int 타입을 가지고 돌아감
	
	// 재고추가 : 재고수량을 입력받아서 현재 재고수량에 추가하기 / 현재 재고수량이 얼마인지 보내기
	// 재고감소 : 재고수량을 입력받아서 현재 재고수량에 감소하기
	
	
	
	int addStock(int amount) {
		stockNum += amount; // stockNum = stockNum + amount;
		return stockNum; // 메소드를 호출한 곳으로 값 보내기
	}
	
	int removeStock(int amount) {
		stockNum -= amount; // stockNum = stockNum - amount;
		return stockNum;
		}


	

	
}
