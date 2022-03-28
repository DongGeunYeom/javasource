package classtest;

public class Card {
	//멤버 변수 (인스턴스 변수)
	String kind;
	int number;
	
	//클래스 변수 = 공유의 의미
	static int width = 100; // (초기화를 기본적으로 함)
	static int height = 150;
	
	public Card(String kind, int number) {
		super();
		this.kind = kind;
		this.number = number;
	}
	
	

}
