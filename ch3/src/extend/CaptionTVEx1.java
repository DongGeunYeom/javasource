package extend;

public class CaptionTVEx1 {

public static void main(String[] args) {
	 
	 CaptionTV ctv = new CaptionTV();
	 
	 ctv.channelTv = 10;
	 ctv.changeChannerTvUp();
	 System.out.println("현재 채널 "+ctv.channelTv);
	 
	 ctv.display("Hello World");
	 ctv.caption = true;
	 ctv.display("Hello World");

	 CaptionTV2 ctv2 = new CaptionTV2("black", true, 7, true);
	 ctv2.setChannelTv(12);
	 ctv2.changeChannerTvUp();
	 System.out.println("현재 채널 "+ctv2.getChannelTv());
	 
	}

}
