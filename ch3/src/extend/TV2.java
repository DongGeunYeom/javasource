package extend;

// CaptionTV : TV + caption

public class TV2{
	
	private String colorTv;
	private boolean power;
	private int channelTv;
	
	public TV2(String colorTv, boolean power, int channelTv) {
		super();
		this.colorTv = colorTv;
		this.power = power;
		this.channelTv = channelTv;
	}
	
	public String getColorTv() {
		return colorTv;
	}
	public void setColorTv(String colorTv) {
		this.colorTv = colorTv;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getChannelTv() {
		return channelTv;
	}
	public void setChannelTv(int channelTv) {
		this.channelTv = channelTv;
	}
	
	// 기능 : 전원 on/off, 채널 변경
	void power() {
		power = !power;
	}
	void changeChannerTvUp() {
		channelTv++; // channel = channel +1 ;
	}
	
	void changeChannerTvDown() {
		channelTv--;
	}
	
	
}
