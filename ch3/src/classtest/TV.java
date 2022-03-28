package classtest;

// 클래스 : 객체의 속성과 기능을 코드로 구현

public class TV {
	
	// 속성 : 색상, 전원상태, 채널...
	String colorTv;
	boolean power;
	int channelTv;
	
	// 생성자를 명시하지 않으면
	// 컴파일러가 자동으로 default 생성자를 만들어줌
	
	// 기능 : 전원 on/off, 채널 변경
	void power() {;
		power = !power;
	}
	void changeChannerTvUp() {
		channelTv++; // channel = channel +1 ;
	};
	
	void changeChannerTvDown() {
		channelTv--;
	};
	
	
}
