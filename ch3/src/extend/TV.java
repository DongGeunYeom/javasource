package extend;

// CaptionTV : TV + caption

public class TV {
	
	String colorTv;
	boolean power;
	int channelTv;
		
	// 기능 : 전원 on/off, 채널 변경
	void power() {;
		power = !power;
	}
	
	void changeChannerTvUp() {
		channelTv++; // channel = channel +1 ;
	}
	
	void changeChannerTvDown() {
		channelTv--;
	}
	
}
