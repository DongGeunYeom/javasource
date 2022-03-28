package exam1;

public class IPTV extends ColorTV{

	private String ipAddress;
	
	public IPTV(int size, int color, String ipAddress) {
		super(size, color);
		this.ipAddress = ipAddress;
	}
	
	@Override
	void printProperty() {
		System.out.print("나의 IPTV는 "+getIpAddress()+" 주소의 ");
		super.printProperty();
				
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	
}
