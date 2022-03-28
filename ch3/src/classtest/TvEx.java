package classtest;

public class TvEx {
	public static void main(String[] args) {
		
		// (default 생성자를 호출하여 객체 생성)
		TV tv1 = new TV();
		
		// 초기화
		tv1.colorTv = "black";
		tv1.channelTv = 3;
		tv1.power = false;
		
		
		tv1.power(); // 전원 작동
		System.out.println("현재 전원 상태 "+tv1.power);
		
		
		tv1.changeChannerTvUp(); // 채널 번호 증가
		System.out.println("현재 채널 "+tv1.channelTv);
		
		tv1.changeChannerTvUp(); // 채널 번호 증가
		System.out.println("현재 채널 "+tv1.channelTv);
		
		tv1.changeChannerTvUp(); // 채널 번호 증가
		System.out.println("현재 채널 "+tv1.channelTv);
		

		tv1.power(); // 전원 작동
		System.out.println("현재 전원 상태 "+tv1.power);
		

		
		
	}

}
