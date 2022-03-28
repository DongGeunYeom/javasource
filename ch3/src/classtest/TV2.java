package classtest;

// 클래스 : 객체의 속성과 기능을 코드로 구현

public class TV2 {
	
	// 속성 : 색상, 전원상태, 채널...
	String colorTv;
	boolean power;
	int channelTv;
	
	// 생성자
		public TV2(String colorTv) {
			this.colorTv=  colorTv;
		}
		
		public TV2(String colorTv, boolean power, int channelTv) {
			this.colorTv=  colorTv;
			this.power = power;
			this.channelTv = channelTv;
		}
		
		public TV2(String colorTv, boolean power) {
			this.colorTv=  colorTv;
			this.power = power;
		}
		
		
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
