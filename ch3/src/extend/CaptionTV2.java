package extend;

public class CaptionTV2 extends TV2{
	

		// 캡션 기능
		boolean caption;
		void display(String text) {
			if(caption) {
				System.out.println(text);
			}
		}
		
		public CaptionTV2(String colorTv, boolean power, int channelTv, boolean caption) {
			super(colorTv, power, channelTv); // 부모의 인자를 받는 생성자 호출
			this.caption = caption;
		}
}
		
		
	// Implicit super constructor TV2() is undefined for default constructor.
	// Must define an explicit constructor.
		
//	public CaptionTV2() {
//		super();  // 부모의 default 생성자 호출
//	}
	
	
//	String colorTv;
//	boolean power;
//	int channelTv;


//	// 기능 : 전원 on/off, 채널 변경
//	void power() {;
//		power = !power;
//	}
//	void changeChannerTvUp() {
//		channelTv++; // channel = channel +1 ;
//	};
//	
//	void changeChannerTvDown() {
//		channelTv--;
//	};
//	

